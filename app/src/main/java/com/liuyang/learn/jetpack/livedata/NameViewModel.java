package com.liuyang.learn.jetpack.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NameViewModel extends ViewModel {

  /**
   * 既是观察者也是被观察者
   */
  private MutableLiveData<String> currentName;
  public int i;

  public MutableLiveData<String> getCurrentName() {
    if (currentName == null) {
      currentName = new MutableLiveData<>();
    }
    return currentName;
  }
}
