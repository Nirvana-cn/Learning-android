package com.example.fragmentatruntime;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button button = view.findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                MainActivity.fragmentManager.beginTransaction().replace(R.id.container, new FirstFragment(), null).addToBackStack(null).commit();
            }
        });

        return view;
    }

}
