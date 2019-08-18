package com.example.recyclerexample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {
    private int selectedPosition = -1;
    private int[] images;
    private int[] counts;
    private Context context;

    public RecyclerAdapter(int[] images,int[] counts, Context context) {
        this.images = images;
        this.counts = counts;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view, context, images);

        return imageViewHolder;
    }

    public void notifyChange(){
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, final int position) {
        int image_id = images[position];
        String string = "click number: "+ counts[position];
        holder.AlbumTitle.setText(string);
        holder.AlbumTitle.setBackgroundColor(Color.parseColor("#FFAAAA"));
        holder.Album.setImageResource(image_id);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPosition = position;
                counts[position]++;
                notifyChange();

                // 也可以通过Class.this访问类的实例方法
                // RecyclerAdapter.this.notifyDataSetChanged();
            }
        });

        if(position == selectedPosition){
            holder.AlbumTitle.setBackgroundColor(Color.parseColor("#AAFFAA"));
            Log.d("test","selected");
        }

        Log.d("test","draw view");
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView Album;
        TextView AlbumTitle;
        Context context;
        int[] images;


        public ImageViewHolder(View view, Context context, int[] images) {
            super(view);
            Album = view.findViewById(R.id.album);
            AlbumTitle = view.findViewById(R.id.album_title);
            view.setOnClickListener(this);
            this.context = context;
            this.images = images;
        }

        @Override
        public void onClick(View view){
            Log.d("test","click...");
//            Intent intent = new Intent(context, DisplayActivity.class);
//            intent.putExtra("image_id",images[getAdapterPosition()]);
//            context.startActivity(intent);
        }
    }
}
