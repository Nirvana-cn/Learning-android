package com.example.fragmentcommunication;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {


    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EventBus.getDefault().register(DisplayFragment.this);
        return inflater.inflate(R.layout.fragment_display, container, false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEventBus(MessageEvent messageEvent) {
        TextView textView = getView().findViewById(R.id.display);
        textView.setText(messageEvent.value);
    }

}
