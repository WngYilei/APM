package com.xl.kit_common;
import android.util.Log;

public class LogHelper {
    private static final String TAG = "APMKit";

    public static void e(String subTag, String msg) {
        Log.e(TAG, "[" + subTag + "]: " + msg);
    }

}
