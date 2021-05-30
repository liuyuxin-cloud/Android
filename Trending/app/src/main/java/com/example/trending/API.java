package com.example.trending;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("/repo")
    Call<list> getList(@Query("lang")String language, @Query("since")String weekly);



}
