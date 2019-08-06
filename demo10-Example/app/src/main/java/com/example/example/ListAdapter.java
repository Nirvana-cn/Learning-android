package com.example.example;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter {
    
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_template, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            ListActivity.fragmentManager.beginTransaction().replace(R.id.container, new ListDetailFragment(), null).addToBackStack(null).commit();
        }
    }
}
