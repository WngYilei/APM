package com.xl.kit_common;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import java.lang.reflect.InvocationTargetException;

public class XApp {

    private static Application application;
    private XApp() {
        throw new UnsupportedOperationException("unable to initialize");
    }
    public static void init( final Application app) {
        if (application == null) {
            application = app;
        }
    }
    protected static void init( final Context context) {
        init((Application) context.getApplicationContext());
    }
    public static Application getApp() {
        if (application != null) {
            return application;
        }
        try {
            @SuppressLint("PrivateApi")
            Class<?> activityThread = Class.forName("android.app.ActivityThread");
            Object at = activityThread.getMethod("currentActivityThread").invoke(null);
            Object app = activityThread.getMethod("getApplication").invoke(at);
            if (app == null) {
                throw new NullPointerException("u should init first");
            }
            init((Application) app);
            return application;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new NullPointerException("u should init first");
    }
}
