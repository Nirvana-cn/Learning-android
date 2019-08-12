package com.example.networkrequest;

import android.util.Log;

public class StartHTTP {
    private static StartHTTP instance = new StartHTTP();

    private StartHTTP() {

    }

    public static StartHTTP getInstance(){
        return instance;
    }

    public void show(){
        Log.d("test","hello world");
    }

}
