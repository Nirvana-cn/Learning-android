package com.example.fragmentcommunication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private EditText editText;
    private Button button;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        editText = view.findViewById(R.id.text_message);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });
        return view;
    }

}
