package com.example.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.example.MainActivity.fragmentManager;

public class ListActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        fragmentManager = getSupportFragmentManager();
        if(findViewById(R.id.container) != null){
            if(savedInstanceState != null){
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ListFragment listFragment = new ListFragment();
            fragmentTransaction.add(R.id.container, listFragment, null);
            fragmentTransaction.commit();
        }

        button = findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }
}
