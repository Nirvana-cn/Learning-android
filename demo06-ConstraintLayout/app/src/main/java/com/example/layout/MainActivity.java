package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if(findViewById(R.id.container) != null){
            if(savedInstanceState != null){
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            IndexFragment indexFragment = new IndexFragment();
            fragmentTransaction.add(R.id.container, indexFragment, null);
            fragmentTransaction.commit();
        }

        Button button = findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                fragmentManager.beginTransaction().replace(R.id.container, new NextFragment(), null).commit();
            }
        });

        WindowManager windowManager = this.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int heiget = displayMetrics.heightPixels;
        String str1 = width+"";
        String str2 = heiget+"";
        Log.d("test",str1);
        Log.d("test",str2);

    }
}
