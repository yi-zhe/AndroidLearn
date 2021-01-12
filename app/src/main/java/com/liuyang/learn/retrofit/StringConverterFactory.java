package com.liuyang.learn.retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class StringConverterFactory extends Converter.Factory {
  public static StringConverterFactory create() {
    return new StringConverterFactory();
  }

  @Override
  public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
      Retrofit retrofit) {
    if (type == String.class) {
      return new StringConverter();
    } else {
      return null;
    }
  }
}
