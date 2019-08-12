package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.databinding.databinding.ActivityMainBinding;
import com.example.databinding.viewModel.User;

public class MainActivity extends AppCompatActivity {
    private User user;
    private EventHandle eventHandle;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user = new User("lucas", "22");
        eventHandle = new EventHandle();
        activityMainBinding.setUserInfo(user);
        activityMainBinding.setHandle(eventHandle);

    }



    public void sendMessage(View view){
        user.setName("hello world");
        user.setAge("100");
        Log.d("test","click is ok");
    }
}
