package com.liuyang.learn.jetpack.lifecycle;

import android.util.Log;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 所有用OnLifecycleEvent注解的方法，通过反射存储在CallbackInfo中
 * 事件和方法的映射
 * final Map<Lifecycle.Event, List<MethodReference>> mEventToHandlers;
 * 方法和事件的映射
 * final Map<MethodReference, Lifecycle.Event> mHandlerToEvent;
 *
 * 用的时候是在ReportFragment的生命周期方法中调用handleLifecycleEvent
 *
 * ComponentActivity
 *     -> ReportFragment -> injectIfNeededIn(this)
 *                       -> dispatch(Event)
 *                       -> handleLifecycleEvent
 *     -> LifecycleRegistry -> moveToState
 *                          -> sync
 *                          -> forwardPass/backwardPass 两个方向
 *
 *     -> ObserverWithState -> dispatchEvent
 *     -> ReflectiveGenericLifecycleObserver
 *                          -> onStateChanged
 *     -> CallbackInfo      -> invokeCallbacks
 *     -> ClassInfoCache    -> invokeCallback
 *                          -> mMethod.invoke(target, source);
 */
public class BaseObserver implements LifecycleObserver {
  private static final String TAG = BaseObservable.class.getSimpleName();

  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public void onCreate() {
    Log.i(TAG, "onCreate");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public void onStart() {
    Log.i(TAG, "onStart");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onResume() {
    Log.i(TAG, "onResume");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onPause() {
    Log.i(TAG, "onPause");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void onStop() {
    Log.i(TAG, "onStop");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onDestroy() {
    Log.i(TAG, "onDestroy");
  }
}
