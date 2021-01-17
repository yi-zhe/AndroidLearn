package com.liuyang.learn;

import android.app.Application;
import com.liuyang.learn.jetpack.hilt.httpprocessor.HttpHelper;
import com.liuyang.learn.jetpack.hilt.httpprocessor.OkHttpProcessor;

public class App extends Application {
  public static App sApp;

  @Override
  public void onCreate() {
    super.onCreate();
    sApp = this;
    HttpHelper.obtain().init(new OkHttpProcessor());
  }
}
