package com.example.arouter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                ARouter.getInstance()
                        .build(RouterURL.ACTIVITY_DETAIL)
                        .navigation();
                break;
            case R.id.bt2:
                ARouter.getInstance()
                        .build(RouterURL.ACTIVITY_ABOUT)
                        .navigation();
                break;
        }
    }
}
