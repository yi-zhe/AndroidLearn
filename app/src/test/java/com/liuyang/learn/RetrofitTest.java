package com.liuyang.learn;

import com.liuyang.learn.retrofit.StringConverterFactory;
import com.liuyang.learn.retrofit.http.GitHubService;
import com.liuyang.learn.retrofit.model.User;
import java.io.File;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

public class RetrofitTest {

  private Retrofit retrofit;
  private GitHubService service;

  @Before
  public void setUp() throws Exception {
    retrofit = new Retrofit.Builder()
        .baseUrl(GitHubService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    service = retrofit.create(GitHubService.class);
  }

  @Test
  public void testFollowing() throws Exception {
    Call<List<User>> userFollowing = service.getUserFollowings("yi-zhe", "id");
    Response<List<User>> response = userFollowing.execute();
    List<User> users = response.body();
    System.out.println("users: " + users.toString());
  }

  @Test
  public void testNewUser() throws Exception {
    Call<User> userFollowing = service.createUser(new User());
    Response<User> response = userFollowing.execute();
    User user = response.body();
    System.out.println("user: " + user);
  }

  @Test
  public void testFormSummit() throws Exception {
    Call<User> user = service.updateUser("Jack", "Lucy");
    User body = user.execute().body();
    System.out.println("user: " + body);
  }

  @Test
  public void testMultipart() throws Exception {
    File file = new File("launcher.png");
    // 以数据流形式
    MediaType mediaType = MediaType.parse("application/octet-stream");
    RequestBody photo = RequestBody.create(mediaType, file);
    // 以文件方式
    RequestBody description = RequestBody.create(MediaType.parse("text/plain"), "description");
    Call<User> updateUser = service.updateUser(photo, description);
    Response<User> response = updateUser.execute();
    System.out.println("user: " + response.body());
  }

  @Test
  public void testStringConverter() throws Exception {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(GitHubService.BASE_URL)
        .addConverterFactory(StringConverterFactory.create())
        .build();
    GitHubService service = retrofit.create(GitHubService.class);
    Call<String> result = service.getUser4Str("yi-zhe");
    String body = result.execute().body();
    System.out.println("body:" + body.toString());
  }

  @After
  public void tearDown() throws Exception {
    // release resource here
  }
}
