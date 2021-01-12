package com.liuyang.learn.utils;

import com.liuyang.learn.App;

public class Toast {
  public static void show(String s) {
    android.widget.Toast.makeText(App.sApp, s, android.widget.Toast.LENGTH_SHORT).show();
  }
}
