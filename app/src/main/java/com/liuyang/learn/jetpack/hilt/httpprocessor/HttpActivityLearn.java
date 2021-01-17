package com.liuyang.learn.jetpack.hilt.httpprocessor;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.liuyang.learn.App;
import com.liuyang.learn.jetpack.hilt.httpprocessor.annotation.BindOkHttp;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@AndroidEntryPoint
public class HttpActivityLearn extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String url = "https://v.juhe.cn/historyWeather/citys";
    Map<String, Object> params = new HashMap<>();
    params.put("province_id", "2");
    params.put("key", "bb52107206585ab074f5e59a8c73875b");
    //HttpHelper.obtain().post(url, params, new HttpCallback<ResponceData>() {
    //  @Override
    //  public void onSuccess(ResponceData objResult) {
    //    Toast.makeText(HttpActivityLearn.this, objResult.getResultcode(),
    //        Toast.LENGTH_SHORT).show();
    //  }
    //});
    App.sApp.getHttpProcessor().post(url, params, new HttpCallback<ResponceData>() {
      @Override
      public void onSuccess(ResponceData objResult) {
        Toast.makeText(HttpActivityLearn.this, objResult.getResultcode(),
            Toast.LENGTH_SHORT).show();
      }
    });
  }
}
