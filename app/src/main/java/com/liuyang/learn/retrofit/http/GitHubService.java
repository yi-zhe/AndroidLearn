package com.liuyang.learn.retrofit.http;

import com.liuyang.learn.retrofit.model.User;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface GitHubService {

  String BASE_URL = "https://api.github.com/";

  /**
   * 获取用户信息1
   *
   * @param user 用户名
   */
  @GET("users/{user}")
  Call<User> getUser(@Path("user") String user);

  /**
   * 获取用户信息2
   *
   * @param user 用户名
   */
  // 使用HTTP注解，可以代替其他几种注解
  // 如果是POST，hasBody改为true
  @HTTP(method = "GET", path = "users/{user}", hasBody = false)
  Call<User> getUser4Http(@Path("user") String user);

  /**
   * 获取一个用户的关注用户
   * Query在链接后带一个参数
   *
   * @param user 用户名
   * @param sort sortBy
   */
  @GET("users/{user}/following")
  Call<List<User>> getUserFollowings(@Path("user") String user, @Query("sort") String sort);

  /**
   * 获取一个公司下的所有用户
   *
   * @param groupId 公司id
   * @param options 参数
   */
  @GET("group/{id}/users")
  Call<List<User>> groupList(@Path("id") int groupId,
      @QueryMap Map<String, String> options);

  /**
   * 在Github上创建用户
   *
   * @param user 用户实体
   *
   * 使用Body注解，将User对象携带过去
   */
  @POST("users/new")
  Call<User> createUser(@Body User user);

  /**
   * 更改用户名
   *
   * @param first firstName
   * @param last lastName
   *
   * 使用Field注解配合FormUrlEncoded 提交表单的键值对信息
   * FieldMap传递多个键值对信息
   */
  @FormUrlEncoded
  @POST("user/edit")
  Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);

  @Multipart
  @PUT("user/photo")
  Call<User> updateUser(@Part("photo") RequestBody photo,
      @Part("description") RequestBody description);

  /**
   * Headers注解添加多个Header
   *
   * @param username 用户名
   */
  @Headers({
      "Accept: application/vnd.github.v3.full+json",
      "User-Agent: Retrofit-Sample-App"
  })
  @GET("user/{username}")
  Call<User> getUser2(@Path("username") String username);

  /**
   * 使用Header注解添加不固定请求头
   *
   * @param lang 语言
   * @param username 用户名
   */
  @GET("user/{username}")
  Call<User> getUser3(@Header("Accept-Language") String lang, @Path("username") String username);

  /**
   * 返回String的接口
   *
   * @param user 用户名
   */
  @GET("users/{user}")
  Call<String> getUser4Str(@Path("user") String user);

  /**
   * Streaming 作用于方法体。以流的形式返回，不会解析数据占用内存，当返回数据比较大时候使用
   * URL 完整的请求URL，当baseURL不一致的时候可以使用
   */
}
