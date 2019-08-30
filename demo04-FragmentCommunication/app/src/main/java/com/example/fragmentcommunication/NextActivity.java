package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, NextActivity.class);
        context.startActivity(intent);
    }

    public void postEvent(View view) {
        EventBus.getDefault().post(new MessageEvent("data", "123"));
    }
}
