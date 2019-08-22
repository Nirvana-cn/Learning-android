package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class NextActivity extends BaseActivity {
    private LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    }

    public void sendLocalBroadcast(View view) {
        Intent intent = new Intent("android.intent.action.LOCAL");
        localBroadcastManager.sendBroadcast(intent);
    }
}
