package com.example.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
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

        Button button = findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                fragmentManager.beginTransaction().replace(R.id.container, new CategoryFragment(), null).addToBackStack(null).commit();
            }
        });

    }

}
