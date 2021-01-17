package com.liuyang.learn;

import android.app.Application;
import com.liuyang.learn.jetpack.hilt.httpprocessor.HttpHelper;
import com.liuyang.learn.jetpack.hilt.httpprocessor.IHttpProcessor;
import com.liuyang.learn.jetpack.hilt.httpprocessor.OkHttpProcessor;
import com.liuyang.learn.jetpack.hilt.httpprocessor.annotation.BindOkHttp;
import dagger.hilt.android.HiltAndroidApp;
import javax.inject.Inject;

@HiltAndroidApp
public class App extends Application {
  public static App sApp;

  @BindOkHttp
  @Inject
  IHttpProcessor httpProcessor;

  public IHttpProcessor getHttpProcessor() {
    return httpProcessor;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    sApp = this;
    HttpHelper.obtain().init(new OkHttpProcessor());
  }
}
