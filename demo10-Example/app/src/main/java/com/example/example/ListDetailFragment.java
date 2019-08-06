package com.example.example;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListDetailFragment extends Fragment {
    private RecyclerView recyclerView;
    private ListDetailAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[] strings = {"三国里的博物学第1集", "三国里的博物学第2集", "三国里的博物学第3集", "三国里的博物学第4集", "三国里的博物学第5集"};


    public ListDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_detail, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        Context context = getActivity();
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ListDetailAdapter(strings);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        return view;
    }

}
