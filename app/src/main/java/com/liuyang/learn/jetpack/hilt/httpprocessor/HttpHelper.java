package com.liuyang.learn.jetpack.hilt.httpprocessor;

import java.util.Map;

public class HttpHelper implements IHttpProcessor {

  private static HttpHelper instance = new HttpHelper();

  public static HttpHelper obtain() {
    return instance;
  }

  private HttpHelper() {

  }

  private static IHttpProcessor mHttpProcessor = null;

  public void init(IHttpProcessor httpProcessor) {
    mHttpProcessor = httpProcessor;
  }

  @Override
  public void post(String url, Map<String, Object> params, ICallback callback) {
    mHttpProcessor.post(url, params, callback);
  }
}
