package com.liuyang.learn.jetpack.hilt.httpprocessor;

import java.util.Map;

public interface IHttpProcessor {
  // 网络访问的能力
  void post(String url, Map<String, Object> params, ICallback callback);
}
