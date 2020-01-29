package com.singh.rajeev.zomatotest.common;

import android.util.Log;

public class LogHelper {

    public static void log(String key, String value) {
        if (BuildConstants.DEBUG) {
            Log.d(key, value);
        }
    }

    public static void log(String value) {
        if (BuildConstants.DEBUG) {
            Log.d(BuildConstants.APP_NAME, value);
        }
    }
}
