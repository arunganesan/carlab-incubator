package edu.umich.eecs.rtcl.carlab;

import android.app.Activity;

/**
 * Created by arunganesan on 1/21/18.
 */

public class Constants {
    public static final String SHARED_PREFS_NAME = "SharedPrefsForCarLab";
    public static final String INTENT_NEW_DATA = "edu.umich.eecs.rtcl.carlab.NEWDATA";
    public static final String INTENT_START_DATA = "edu.umich.eecs.rtcl.carlab.START_DATA";
    public static final String INTENT_STOP_DATA = "edu.umich.eecs.rtcl.carlab.STOP_DATA";
    public static final String INTENT_APP_STATE_UPDATE = "edu.umich.eecs.rtcl.carlab.APP_STATE_UPDATE";
    public static final String INTENT_AUTOSTART = "edu.umich.eecs.rtcl.carlab.AUTOSTART";

    public static final int TAG_CODE_PERMISSION_LOCATION = 777;

    public static final double VERSION = 0.3;

    // TODO This needs to be read from some place else. Maybe from shared preferences? Where is this stored?
    public static String UID = "";
    public static String tripid = "";

    /** Database constants */
    public static final String DB_NAME = "OPA";
    public static final String DB_TABLE_NAME = "data";
    public static final String DB_ROWID_NAME = "rowid";
    public static final String DB_TIME_NAME = "time";
    public static final String DB_DEVICE_NAME = "device";
    public static final String DB_SENSOR_NAME = "sensor";
    public static final String DB_VALUE_NAME = "value";
    public static final String DB_FORMATTED_NAME = "formatted";
    public static final String DB_UID_NAME = "uid";
    public static final String DB_TRIPID_NAME = "tripid";
    public static final String DB_URL_NAME = "url";

    public static final int DB_VERSION = 13;
    public static final int MAX_UPLOAD_SIZE = 500;

    public final static int GPS_INTERVAL = 500;
    public final static int OXC_PERIOD = 500;

    public static final int AUTOSTART_DISCOVERY_TIME = 15000;
    public static final int AUTOSTART_RETRY_TIME = 5*60*1000;

    /** Upload URL */
    public static final String BASE_URL = "http://barca.eecs.umich.edu:9000/";
    public static final String SigninURL = BASE_URL + "createaccount";
    public static final String TripEndURL = BASE_URL + "endedtrip";
    public static final String DEFAULT_UPLOAD_URL = BASE_URL + "/upload";
    public static final String MEDIA_UPLOAD_URL = BASE_URL + "/uploadMedia";
    public static final int CARLAB_NOTIFICATION_ID = 0x818;
    public static long RemainingDataCount = 0L;

    /* File Saving */
    public static final String SaveDir = "carlab-traces";

    public static Activity runningActivity = null;

    /* Display parameters */
    public static final int ROW_HEIGHT = 350;
    public static final String Notification_Channel = "carlab_channel_01";

    /* Shared preferences keys */
    public static final String BLUETOOTH_LIST_KEY = "BluetoothListKey";
    public static final String SELECTED_BLUETOOTH_KEY = "Bluetooth Selected Device";
    public static final String AUTOSTART_PREF_KEY = "Autostart pref key";
    public static final String MAX_DATA_STORAGE_KEY = "max storage key";
    public static final String ACTIVE_APPS_KEY = "active apps keys";
    public static String UID_key = "uid";
    public static String Profile_key = "profilePhotoUrl";
    public static String Profile_Image = "profilePhotoData";

    public static final int ProfileTrianglePositionDp = 75;
    public static final int BluetoothTrianglePositionDp = 142;
    public static final int SettingsTrianglePositionDp = 212;
    public static final int AppsTrianglePositionDp = 281;

    public static final String ProfilePageName = "Profile";
    public static final String ConnectivityPageName = "Conn";
    public static final String SettingsPageName = "Sett";
    public static final String AppsPageName = "App";


    /** Return value codes **/
    public final static float GENERAL_POLL_ERROR = -1;
    public final static float NO_GPS_PERMISSION_ERROR = -2;
    public final static float GENERAL_ERROR = -3;
    public final static float GPS_STARTED_STATUS = 2;
    public final static float STARTING_STATUS = 3;
    public final static float GENERAL_STATUS = 4;

    public static final String PreviousPageKey = "previousPage";

    /* Intents flying around */
    public static final String MASTER_SWITCH_ON = "MasterSwitchON";
    public static final String MASTER_SWITCH_OFF = "MasterSwitchOFF";
    public static final String DONE_INITIALIZING_CL = "CanEnableMSNow";

}
