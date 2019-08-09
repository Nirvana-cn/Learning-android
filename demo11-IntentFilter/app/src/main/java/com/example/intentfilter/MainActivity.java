package com.example.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void sendMessage(View view){
        Intent intent = new Intent();
        EditText editText = findViewById(R.id.editText);
        String str = editText.getText().toString();
        Log.d("test",str);
        if(str.equals("1")){
            intent.setAction("com.example.intentfilter.first");
        }else{
            intent.setAction("test");
        }
        startActivity(intent);
    }
}
