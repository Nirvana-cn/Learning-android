package com.example.relativelayout;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private String str = "https://raw.githubusercontent.com/Nirvana-cn/Photograph-deposit/master/douyu/video1.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.pic);
        Picasso.with(this).load(str).into(imageView);
    }

}
