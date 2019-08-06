package com.example.example;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private int[] images = {R.drawable.test};
    private String[] strings = {"国学经典", "童谣儿歌", "科普知识", "精彩绘本", "英语乐园", "奇妙数学", "你画我猜"};

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        Context context = getActivity();
        layoutManager = new GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CategoryAdapter(strings, images, context);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;
    }

}
