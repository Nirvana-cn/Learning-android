package com.example.fragmentcommunication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    private Listener listener;
    private EditText editText;
    private Button bFragment;
    private Button bActivity;
    private Button bBus;
    private FragmentManager manager;

    public MessageFragment() {
        // Required empty public constructor
    }

    public interface Listener {
        void show(String string);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // onCreate时获取宿主的FragmentManager
        manager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        // 通过getArguments获取数据
        String initStr = (String) getArguments().get("name");
        editText = view.findViewById(R.id.text_message);
        editText.setText(initStr);

        bFragment = view.findViewById(R.id.button);
        bActivity = view.findViewById(R.id.button2);
        bBus = view.findViewById(R.id.button3);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        // 向另一个Fragment传递数据
        bFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 通过manager.findFragmentByTag
                DisplayFragment displayFragment = (DisplayFragment) manager.findFragmentByTag("bottom");
                TextView textView = displayFragment.getView().findViewById(R.id.display);
                textView.setText(editText.getText());
            }
        });


        // 向Activity返回数据
        bActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.show(editText.getText().toString());
            }
        });

        // 使用Event Bus
        bBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("data", editText.getText().toString()));
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Listener) {
            listener = ((Listener) context);
        } else {
            throw new IllegalArgumentException("Activity must implements Listener");
        }
    }
}
