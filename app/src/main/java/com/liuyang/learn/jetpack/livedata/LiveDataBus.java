package com.liuyang.learn.jetpack.livedata;

import androidx.lifecycle.MutableLiveData;
import java.util.HashMap;
import java.util.Map;

/**
 * LiveData总线
 * 版本1: 由于粘性问题，先发消息，后面注册的也能收到消息，略有不爽
 * 修改为SingletonHolder的实现方式
 */
public class LiveDataBus {
  // 存放订阅者
  private final Map<String, MutableLiveData<Object>> bus;

  private LiveDataBus() {
    bus = new HashMap<>();
  }

  private static class SingletonHolder {
    private static final LiveDataBus DATA_BUS = new LiveDataBus();
  }

  public static LiveDataBus get() {
    return SingletonHolder.DATA_BUS;
  }

  public <T> MutableLiveData<T> getChannel(String target, Class<T> type) {
    if (!bus.containsKey(target)) {
      bus.put(target, new MutableLiveData<>());
    }
    return (MutableLiveData<T>) bus.get(target);
  }

  public MutableLiveData<Object> getChannel(String target) {
    return getChannel(target);
  }
}
