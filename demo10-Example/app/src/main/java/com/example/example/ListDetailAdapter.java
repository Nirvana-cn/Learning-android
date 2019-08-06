package com.example.example;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListDetailAdapter extends RecyclerView.Adapter<ListDetailAdapter.MyViewHolder> {

    private String[] strings;
    public ListDetailAdapter(String[] strings) {
        this.strings = strings;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_list_template, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(strings[position]);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;

        public MyViewHolder(View view) {
            super(view);
            this.textView = view.findViewById(R.id.listName);
        }

        public void onClick(View view){

        }
    }
}
