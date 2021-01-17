package com.liuyang.learn.jetpack.hilt.httpprocessor;

public interface ICallback {
  void onSuccess(String result);

  void onFailure(String e);
}
