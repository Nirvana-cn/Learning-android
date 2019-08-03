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
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button button = view.findViewById(R.id.b2);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                MainActivity.fragmentManager.beginTransaction().replace(R.id.container, new SecondFragment(), null).addToBackStack(null).commit();
            }
        });

        return view;
    }

}
