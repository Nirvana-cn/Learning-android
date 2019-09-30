package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.databinding.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public static UserViewModel userViewModel;
    private EventHandle eventHandle;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        userViewModel = new UserViewModel("lucas", "22");
        eventHandle = new EventHandle();
        activityMainBinding.setUserInfo(userViewModel);
        activityMainBinding.setHandle(eventHandle);

        Timer mTimer = new Timer();
        TimerTask mTimerTask = new TimerTask() {
            @Override
            public void run() {
                UserViewModel.update();
            }
        };
        mTimer.schedule(mTimerTask, 3000);
    }
}
