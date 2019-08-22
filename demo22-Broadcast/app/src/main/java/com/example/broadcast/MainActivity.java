package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {
    private LocalBroadcast startLocalBroadcast;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCAL");
        startLocalBroadcast = new LocalBroadcast();
        localBroadcastManager.registerReceiver(startLocalBroadcast, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(startLocalBroadcast);
    }

    class LocalBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            System.out.println("Main receive local broadcast!!!");
        }
    }

    // 启动BroadcastCustom
    public void sendBroadcast(View view) {
        Intent intent = new Intent("android.intent.action.MY_BROADCAST");
        sendBroadcast(intent);
    }

    public void startNext(View view) {
        Intent intent = new Intent(this, NextActivity.class);
        startActivity(intent);
    }
}
