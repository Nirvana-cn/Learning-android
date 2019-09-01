package com.example.fragmentcommunication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void messageEventBus(MessageEvent messageEvent) {
        System.out.println("收到message事件");
        EventBus.getDefault().post(new ServiceEvent(messageEvent.value));
    }

}
