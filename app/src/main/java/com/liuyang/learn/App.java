package com.liuyang.learn;

import android.app.Application;

public class App extends Application {
  public static App sApp;

  @Override
  public void onCreate() {
    super.onCreate();
    sApp = this;
  }
}
