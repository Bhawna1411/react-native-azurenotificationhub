package com.azure.reactnative.notificationhub;

public final class ReactNativeConstants {
    // Notification
    public static final String AZURE_NOTIFICATION_HUB_NAME = "AzureNotificationHub";
    public static final String NOTIF_REGISTER_AZURE_HUB_EVENT = "azureNotificationHubRegistered";
    public static final String NOTIF_AZURE_HUB_REGISTRATION_ERROR_EVENT = "azureNotificationHubRegistrationError";
    public static final String DEVICE_NOTIF_EVENT = "remoteNotificationReceived";
    public static final String NOTIFICATION_CHANNEL_ID = "rn-push-notification-channel-id";

    // Shared prefs used in NotificationHubUtil
    public static final String SHARED_PREFS_NAME = "com.azure.reactnative.notificationhub.NotificationHubUtil";
    public static final String KEY_FOR_PREFS_REGISTRATIONID = "AzureNotificationHub_registrationID";
    public static final String KEY_FOR_PREFS_CONNECTIONSTRING = "AzureNotificationHub_connectionString";
    public static final String KEY_FOR_PREFS_HUBNAME = "AzureNotificationHub_hubName";
    public static final String KEY_FOR_PREFS_FCMTOKEN = "AzureNotificationHub_FCMToken";
    public static final String KEY_FOR_PREFS_TAGS = "AzureNotificationHub_Tags";
    public static final String KEY_FOR_PREFS_SENDERID = "AzureNotificationHub_senderID";
    public static final String KEY_FOR_PREFS_CHANNELIMPORTANCE = "AzureNotificationHub_channelImportance";
    public static final String KEY_FOR_PREFS_CHANNELSHOWBADGE = "AzureNotificationHub_channelShowBadge";
    public static final String KEY_FOR_PREFS_CHANNELENABLELIGHTS = "AzureNotificationHub_channelEnableLights";
    public static final String KEY_FOR_PREFS_CHANNELENABLEVIBRATION = "AzureNotificationHub_channelEnableVibration";

    // Remote notification payload
    public static final String KEY_REMOTE_NOTIFICATION_MESSAGE = "message";
    public static final String KEY_REMOTE_NOTIFICATION_ID = "google.message_id";
    public static final String KEY_REMOTE_NOTIFICATION_TITLE = "title";
    public static final String KEY_REMOTE_NOTIFICATION_PRIORITY = "google.original_priority";
    public static final String KEY_REMOTE_NOTIFICATION_TICKER = "ticker";
    public static final String KEY_REMOTE_NOTIFICATION_AUTO_CANCEL = "autoCancel";
    public static final String KEY_REMOTE_NOTIFICATION_GROUP = "group";
    public static final String KEY_REMOTE_NOTIFICATION_LARGE_ICON = "largeIcon";
    public static final String KEY_REMOTE_NOTIFICATION_SUB_TEXT = "subText";
    public static final String KEY_REMOTE_NOTIFICATION_NUMBER = "number";
    public static final String KEY_REMOTE_NOTIFICATION_SMALL_ICON = "smallIcon";
    public static final String KEY_REMOTE_NOTIFICATION_BIG_TEXT = "bigText";
    public static final String KEY_REMOTE_NOTIFICATION_PLAY_SOUND = "playSound";
    public static final String KEY_REMOTE_NOTIFICATION_SOUND_NAME = "soundName";
    public static final String KEY_REMOTE_NOTIFICATION_ONGOING = "ongoing";
    public static final String KEY_REMOTE_NOTIFICATION_COLOR = "color";
    public static final String KEY_REMOTE_NOTIFICATION_VIBRATE = "vibrate";
    public static final String KEY_REMOTE_NOTIFICATION_VIBRATION = "vibration";
    public static final String KEY_REMOTE_NOTIFICATION_FOREGROUND = "foreground";
    public static final String KEY_REMOTE_NOTIFICATION_ACTIONS = "actions";
    public static final String KEY_REMOTE_NOTIFICATION_ACTION = "action";
    public static final String KEY_REMOTE_NOTIFICATION_TAG = "tag";
    public static final String KEY_REMOTE_NOTIFICATION_USER_INTERACTION = "userInteraction";
    public static final String KEY_REMOTE_NOTIFICATION_COLDSTART = "coldstart";

    // Remote notification payload's priority
    public static final String REMOTE_NOTIFICATION_PRIORITY_MAX = "max";
    public static final String REMOTE_NOTIFICATION_PRIORITY_HIGH = "high";
    public static final String REMOTE_NOTIFICATION_PRIORITY_LOW = "low";
    public static final String REMOTE_NOTIFICATION_PRIORITY_MIN = "min";
    public static final String REMOTE_NOTIFICATION_PRIORITY_NORMAL = "normal";

    // Intent payload
    public static final String KEY_INTENT_NOTIFICATION = "notification";

    // Resources
    public static final String RESOURCE_DEF_TYPE_MIPMAP = "mipmap";
    public static final String RESOURCE_DEF_TYPE_RAW = "raw";
    public static final String RESOURCE_NAME_NOTIFICATION = "ic_notification";
    public static final String RESOURCE_NAME_LAUNCHER = "ic_launcher";

    // Errors
    public static final String ERROR_NO_ACTIVITY_CLASS = "No activity class found for the notification";
    public static final String ERROR_NO_MESSAGE = "No message specified for the notification";
    public static final String ERROR_NO_NOTIF_ID = "No notification ID specified for the notification";
    public static final String ERROR_COVERT_ACTIONS = "Exception while converting actions to JSON object.";
    public static final String ERROR_GET_ACTIONS_ARRAY = "Exception while getting action from actionsArray.";
    public static final String ERROR_SEND_PUSH_NOTIFICATION = "failed to send push notification";
    public static final String ERROR_ACTIVITY_CLASS_NOT_FOUND = "Activity class not found";
    public static final String ERROR_INVALID_ARGUMENTS = "E_INVALID_ARGUMENTS";
    public static final String ERROR_INVALID_CONNECTION_STRING = "Connection string cannot be null.";
    public static final String ERROR_INVALID_HUBNAME = "Hub name cannot be null.";
    public static final String ERROR_INVALID_SENDER_ID = "Sender ID cannot be null.";
    public static final String ERROR_PLAY_SERVICES = "E_PLAY_SERVICES";
    public static final String ERROR_PLAY_SERVICES_DISABLED = "User must enable Google Play Services.";
    public static final String ERROR_PLAY_SERVICES_UNSUPPORTED = "This device is not supported by Google Play Services.";
    public static final String ERROR_NOTIFICATION_HUB = "E_NOTIFICATION_HUB";
    public static final String ERROR_NOT_REGISTERED = "E_NOT_REGISTERED";
    public static final String ERROR_NOT_REGISTERED_DESC = "No registration to Azure Notification Hub.";

    private ReactNativeConstants() {
    }
}