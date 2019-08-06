package com.example.networkrequest;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url("http://192.168.30.69:8082/api/apimock/4a53e3c1c0357e43c1bf94437c44c91c/v1/cms/svw/hu/category/page/layout/content/list")
                .build();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                    JSONArray jsonArray = new JSONArray();
                    for (int i=0; i < jsonArray.length(); i++)    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String id = jsonObject.getString("code");
                        Log.d("test-id",id);
                        String name = jsonObject.getString("message");
                        Log.d("test-name",name);
                        String result = jsonObject.getString("result");
                        Log.d("test-result",result);
                    }
                } catch (Exception e) {
                    Log.d("test","hereFail");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d("test","fail");
            }
        });

    }

}
