package com.example.recyclerexample;

import android.content.Context;
import android.content.Intent;
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

    private int[] images;
    private Context context;

    public RecyclerAdapter(int[] images, Context context) {
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view, context, images);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int image_id = images[position];
        holder.AlbumTitle.setText("Image: " + position);
        holder.Album.setImageResource(image_id);

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

        public void onClick(View view){
            Log.d("test","click...");
            Intent intent = new Intent(context, DisplayActivity.class);
            intent.putExtra("image_id",images[getAdapterPosition()]);
            context.startActivity(intent);
        }
    }
}
