package com.azure.reactnative.notificationhub;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import me.leolin.shortcutbadger.ShortcutBadger;

import static com.azure.reactnative.notificationhub.ReactNativeConstants.*;

public class ReactNativeFirebaseMessagingService extends FirebaseMessagingService {
    private SharedPreferences mPrefs;
    private static final String TAG = "ReactNativeFMS";

    private static String notificationChannelID;

    public static void createNotificationChannel(Context context) {
        if (notificationChannelID == null) {
            ReactNativeNotificationHubUtil notificationHubUtil = ReactNativeNotificationHubUtil.getInstance();
            ReactNativeNotificationChannelBuilder builder = ReactNativeNotificationChannelBuilder.Factory.create();

            if (notificationHubUtil.hasChannelName(context)) {
                builder.setName(notificationHubUtil.getChannelName(context));
            }

            if (notificationHubUtil.hasChannelDescription(context)) {
                builder.setDescription(notificationHubUtil.getChannelDescription(context));
            }

            if (notificationHubUtil.hasChannelImportance(context)) {
                builder.setImportance(notificationHubUtil.getChannelImportance(context));
            }

            if (notificationHubUtil.hasChannelShowBadge(context)) {
                builder.setShowBadge(notificationHubUtil.getChannelShowBadge(context));
            }

            if (notificationHubUtil.hasChannelEnableLights(context)) {
                builder.enableLights(notificationHubUtil.getChannelEnableLights(context));
            }

            if (notificationHubUtil.hasChannelEnableVibration(context)) {
                builder.enableVibration(notificationHubUtil.getChannelEnableVibration(context));
            }

            notificationChannelID = NOTIFICATION_CHANNEL_ID;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = builder.build();
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(
                        Context.NOTIFICATION_SERVICE);
                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(channel);
                    notificationChannelID = channel.getId();
                }
            }
        }
    }

    public static void deleteNotificationChannel(Context context) {
        if (notificationChannelID != null) {
            final String channelToDeleteID = notificationChannelID;
            notificationChannelID = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(
                        Context.NOTIFICATION_SERVICE);
                notificationManager.deleteNotificationChannel(channelToDeleteID);
            }
        }
    }

    @Override
    public void onNewToken(String token) {
        Log.i(TAG, "Refreshing FCM Registration Token");

        Intent intent = ReactNativeNotificationHubUtil.IntentFactory.createIntent(this, ReactNativeRegistrationIntentService.class);
        ReactNativeRegistrationIntentService.enqueueWork(this, intent);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        ReactNativeNotificationHubUtil notificationHubUtil = ReactNativeNotificationHubUtil.getInstance();
        Log.d(TAG, "Remote message from: " + remoteMessage.getFrom());

        if (notificationChannelID == null) {
            createNotificationChannel(this);
        }

        Bundle bundle = remoteMessage.toIntent().getExtras();
        if(ShortcutBadger.isBadgeCounterSupported(this)) {
            String badgeCount = bundle.getString("badge");
            SharedPreferences sharedPreferences = PreferenceManager
                    .getDefaultSharedPreferences(this);
            Integer prevCount = sharedPreferences.getInt("badgeCount", 0);
            Integer nextCount = 0;
            if (badgeCount == null) {
                badgeCount = "0";
                nextCount = prevCount + 1;
            } else {
                nextCount = Integer.parseInt(badgeCount);
            }
//        count=count+Integer.parseInt(badgeCount);
            ShortcutBadger.applyCount(this, nextCount);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("badgeCount", nextCount);
            editor.commit();
        }
        if (notificationHubUtil.getAppIsForeground()) {
            bundle.putBoolean(KEY_REMOTE_NOTIFICATION_FOREGROUND, true);
            bundle.putBoolean(KEY_REMOTE_NOTIFICATION_USER_INTERACTION, false);
            bundle.putBoolean(KEY_REMOTE_NOTIFICATION_COLDSTART, false);
            ReactNativeNotificationsHandler.sendNotification(this, bundle, notificationChannelID);
        } else {
            ReactNativeNotificationsHandler.sendNotification(this, bundle, notificationChannelID);
        }

        ReactNativeNotificationsHandler.sendBroadcast(this, bundle, 0);
    }
}
