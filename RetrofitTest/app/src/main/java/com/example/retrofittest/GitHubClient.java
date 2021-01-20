package com.example.retrofittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {           //创建网络请求接口
    @GET("/users/{user}/repos")           //为了动态改变用户{user}将在运行时被替换
    Call<List<GitHubRepo>> reposForUser(@Path("user")String user);
}
