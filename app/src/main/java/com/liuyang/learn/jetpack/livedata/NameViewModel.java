package com.liuyang.learn.jetpack.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NameViewModel extends ViewModel {

  /**
   * 既是观察者也是被观察者
   *
   * ViewModelStore
   *     private final HashMap<String, ViewModel> mMap = new HashMap<>();
   *
   * get(ViewModel.class) 通过反射创建对象，并缓存在mMap
   *
   * Activity调用onRetainCustomNonConfigurationInstance
   *
   * static final class NonConfigurationInstances {
   *   Object activity;
   *   HashMap<String, Object> children;
   *   FragmentManagerNonConfig fragments;
   *   ArrayMap<String, LoaderManager> loaders;
   *   VoiceInteractor voiceInteractor;
   * }
   *
   * 恢复数据 getLastNonConfigurationInstance()
   * 保存数据 onRetainCustomNonConfigurationInstance()
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
