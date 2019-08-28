package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MessageFragment.Listener {
    private FragmentTransaction fragmentTransaction;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.top);

        if (findViewById(R.id.fragment_1) != null) {
            if (savedInstanceState != null) {
                return;
            }

            // 通过Bundle和setArguments向MessageFragment传递初始化数据
            MessageFragment messageFragment = new MessageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", "My name is Jack");
            messageFragment.setArguments(bundle);

            DisplayFragment displayFragment = new DisplayFragment();
            fragmentTransaction = getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_1, messageFragment, null)
                    .add(R.id.fragment_2, displayFragment, "bottom");

            fragmentTransaction.commit();
        }
    }

    @Override
    public void show(String string) {
        textView.setText(string);
    }
}
