package com.liuyang.learn.jetpack.hilt.httpprocessor;

import com.google.gson.Gson;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class HttpCallback<Result> implements ICallback {

  @Override
  public void onSuccess(String result) {
    // result是网络访问第三方框架返回的字符串
    // 得到调用者用何种JavaBean
    Class<?> clz = analysisClassInfo(this);

    // 把result转成clz
    Gson gson = new Gson();
    Result objResult = (Result) gson.fromJson(result, clz);
    onSuccess(objResult);
  }

  public abstract void onSuccess(Result objResult);

  private Class<?> analysisClassInfo(Object object) {
    Type type = object.getClass().getGenericSuperclass();
    Type[] params = ((ParameterizedType) type).getActualTypeArguments();
    return (Class<?>) params[0];
  }

  @Override
  public void onFailure(String e) {

  }
}
