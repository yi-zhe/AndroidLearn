package com.liuyang.learn.jetpack.livedata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过反射 在注册前修改ObserverWrapper.mLastVersion为mVersion
 * 解决了粘性观察问题
 */
public class LiveDataBus2 {
  private final Map<String, BusMutableLiveData<Object>> bus;

  private LiveDataBus2() {
    bus = new HashMap<>();
  }

  private static class SingletonHolder {
    private static final LiveDataBus2 DEFAULT_BUS = new LiveDataBus2();
  }

  public static LiveDataBus2 get() {
    return SingletonHolder.DEFAULT_BUS;
  }

  public <T> MutableLiveData<T> with(String key, Class<T> type) {
    if (!bus.containsKey(key)) {
      bus.put(key, new BusMutableLiveData<>());
    }
    return (MutableLiveData<T>) bus.get(key);
  }

  public MutableLiveData<Object> with(String key) {
    return with(key, Object.class);
  }

  private static class ObserverWrapper<T> implements Observer<T> {

    private Observer<T> observer;

    public ObserverWrapper(Observer<T> observer) {
      this.observer = observer;
    }

    @Override
    public void onChanged(@Nullable T t) {
      if (observer != null) {
        if (isCallOnObserve()) {
          return;
        }
        observer.onChanged(t);
      }
    }

    private boolean isCallOnObserve() {
      StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
      if (stackTrace.length > 0) {
        for (StackTraceElement element : stackTrace) {
          if ("android.arch.lifecycle.LiveData".equals(element.getClassName()) &&
              "observeForever".equals(element.getMethodName())) {
            return true;
          }
        }
      }
      return false;
    }
  }

  private static class BusMutableLiveData<T> extends MutableLiveData<T> {

    private Map<Observer, Observer> observerMap = new HashMap<>();

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
      super.observe(owner, observer);
      try {
        hook(observer);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    @Override
    public void observeForever(@NonNull Observer<? super T> observer) {
      if (!observerMap.containsKey(observer)) {
        observerMap.put(observer, new ObserverWrapper(observer));
      }
      super.observeForever(observerMap.get(observer));
    }

    @Override
    public void removeObserver(@NonNull Observer<? super T> observer) {
      Observer realObserver;
      if (observerMap.containsKey(observer)) {
        realObserver = observerMap.remove(observer);
      } else {
        realObserver = observer;
      }
      super.removeObserver(realObserver);
    }

    private void hook(@NonNull Observer<? super T> observer) throws Exception {
      //get wrapper's version
      Class<LiveData> classLiveData = LiveData.class;
      Field fieldObservers = classLiveData.getDeclaredField("mObservers");
      fieldObservers.setAccessible(true);
      Object objectObservers = fieldObservers.get(this);
      Class<?> classObservers = objectObservers.getClass();
      Method methodGet = classObservers.getDeclaredMethod("get", Object.class);
      methodGet.setAccessible(true);
      Object objectWrapperEntry = methodGet.invoke(objectObservers, observer);
      Object objectWrapper = null;
      if (objectWrapperEntry instanceof Map.Entry) {
        objectWrapper = ((Map.Entry) objectWrapperEntry).getValue();
      }
      if (objectWrapper == null) {
        throw new NullPointerException("Wrapper can not be bull!");
      }
      Class<?> classObserverWrapper = objectWrapper.getClass().getSuperclass();
      Field fieldLastVersion = classObserverWrapper.getDeclaredField("mLastVersion");
      fieldLastVersion.setAccessible(true);
      //get livedata's version
      Field fieldVersion = classLiveData.getDeclaredField("mVersion");
      fieldVersion.setAccessible(true);
      Object objectVersion = fieldVersion.get(this);
      //set wrapper's version
      fieldLastVersion.set(objectWrapper, objectVersion);
    }
  }
}