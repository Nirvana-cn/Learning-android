package com.example.layout;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NextFragment extends Fragment {


    public NextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_next, container, false);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Log.d("test",displayMetrics.widthPixels+"");
        Log.d("test",displayMetrics.heightPixels+"");

        TextView view1 = view.findViewById(R.id.c1);
        Log.d("test",view1.getWidth()+"");
        view1.setHeight(100);
        return view;
    }

}
