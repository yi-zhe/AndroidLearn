package com.liuyang.learn.jetpack.lifecycle;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

public class LifecycleActivityLearn extends AppCompatActivity {

  private BaseObserver baseObservable;

  @Override
  protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(newBase);
    baseObservable = new BaseObserver();
    getLifecycle().addObserver(baseObservable);
  }
}
