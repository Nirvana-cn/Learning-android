package com.example.betterfilestorage;

import android.app.Application;
import android.content.Context;

/**
 * @Auther Alliance
 * @Date 2019/9/4 10:26
 * @Description
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
