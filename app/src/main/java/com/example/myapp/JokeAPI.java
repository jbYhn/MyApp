package com.example.myapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeAPI {
    @GET("/jokes")
    Call<RestJokeResponse> getJokeResponse();
}
