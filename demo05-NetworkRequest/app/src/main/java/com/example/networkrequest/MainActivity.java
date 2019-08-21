package com.example.networkrequest;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private TextView name;
    private TextView age;
    private ImageView image;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        image = findViewById(R.id.image);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 发起网络请求...
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.112:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 创网络请求接口的实例
        AbstractRequest request = retrofit.create(AbstractRequest.class);

        // 对发送请求进行封装
        Call<Translation> call = request.getCall();

        // 发送网络请求(异步)
        call.enqueue(new Callback<Translation>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                System.out.println(response.body().toString());
                Translation.Content target = response.body().getList().get(1);
                name.setText(target.getName());
                age.setText(target.getAge());
                Picasso.with(context).load(target.getUrl()).placeholder(R.drawable.ic_launcher_background).into(image);
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation> call, Throwable throwable) {
                System.out.println("连接失败了");
            }
        });
    }

}
