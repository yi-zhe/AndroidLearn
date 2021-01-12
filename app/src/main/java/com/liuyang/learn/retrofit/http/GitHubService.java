package com.liuyang.learn.retrofit.http;

import com.liuyang.learn.retrofit.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Path;

public interface GitHubService {
  @GET("users/{user}")
  Call<User> getUser(@Path("user") String user);

  // 使用HTTP注解，可以代替其他几种注解
  // 如果是POST，hasBody改为true
  @HTTP(method = "GET", path = "users/{user}", hasBody = false)
  Call<User> getUser4Http(@Path("user") String user);
}
