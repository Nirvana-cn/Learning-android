package com.example.recyclerexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private int[] images = {R.drawable.video1, R.drawable.video2, R.drawable.video3};
    public int[] counts = {0,0,0};

    public static RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new GridLayoutManager(this,1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(images, counts, this);
        boolean res = adapter.hasObservers();
        Log.d("ob",String.valueOf(res));
        recyclerView.setAdapter(adapter);
    }
}
