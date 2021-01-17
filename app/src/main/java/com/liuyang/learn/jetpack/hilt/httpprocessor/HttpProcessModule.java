package com.liuyang.learn.jetpack.hilt.httpprocessor;

import com.liuyang.learn.jetpack.hilt.httpprocessor.annotation.BindOkHttp;
import com.liuyang.learn.jetpack.hilt.httpprocessor.annotation.BindVolley;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import javax.inject.Singleton;

@Module
@InstallIn(ApplicationComponent.class)
public abstract class HttpProcessModule {
  @BindOkHttp
  @Binds
  @Singleton
  abstract IHttpProcessor bindOkHttp(OkHttpProcessor okHttpProcessor);

  @BindVolley
  @Binds
  @Singleton
  abstract IHttpProcessor bindVolley(VolleyProcessor volleyProcessor);
}
