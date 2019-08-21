package com.example.networkrequest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AbstractRequest {
    @GET("/")
    Call<Translation> getCall();
}
