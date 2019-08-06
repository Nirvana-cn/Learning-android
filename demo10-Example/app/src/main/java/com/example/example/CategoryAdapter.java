package com.example.example;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private String[] strings;
    private int[] images;
    private Context context;

    public CategoryAdapter(String[] strings, int[] image, Context context) {
        this.strings = strings;
        this.images = image;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_template, parent, false);
        return new MyViewHolder(view, strings, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(images[0]);
        holder.textView.setText(strings[position]);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView textView;
        private String[] categoryNames;
        private Context context;

        public MyViewHolder(View view, String[] strings, Context context) {
            super(view);
            imageView = view.findViewById(R.id.image);
            textView = view.findViewById(R.id.desc);
            view.setOnClickListener(this);
            this.categoryNames = strings;
            this.context = context;
        }

        public void onClick(View view){
            Log.d("test",categoryNames[getAdapterPosition()]);
            Intent intent = new Intent(context, ListActivity.class);
//            intent.putExtra("image_id", "000");
            context.startActivity(intent);
        }
    }
}
