package com.liuyang.learn.retrofit;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.liuyang.learn.retrofit.http.GitHubService;
import com.liuyang.learn.retrofit.model.User;
import com.liuyang.learn.utils.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitLearn extends AppCompatActivity {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    GitHubService service = retrofit.create(GitHubService.class);
    Call<User> userCall = service.getUser("yi-zhe");
    // enqueue是异步发起请求，execute是同步发起请求
    userCall.enqueue(new Callback<User>() {
      @Override
      public void onResponse(Call<User> call, Response<User> response) {
        Toast.show(response.body().id + "");
      }

      @Override
      public void onFailure(Call<User> call, Throwable t) {
        Toast.show(t.getMessage());
      }
    });
  }
}
