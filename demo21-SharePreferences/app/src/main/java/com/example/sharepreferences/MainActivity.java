package com.example.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bt_write;
    private Button bt_read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_write = findViewById(R.id.write);
        bt_read = findViewById(R.id.read);

        bt_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "tom");
                editor.putInt("age", 20);
                editor.apply();
            }
        });

        bt_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences editor = getSharedPreferences("data", MODE_PRIVATE);
                String name = editor.getString("name", "no");
                int age = editor.getInt("age", 0);
                Log.d("test", name);
                Log.d("test", age + "");
            }
        });


    }
}
