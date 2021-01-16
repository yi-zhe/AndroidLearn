package com.liuyang.learn.jetpack.livedata;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.liuyang.learn.R;
import com.liuyang.learn.utils.Toast;

/**
 * LiveData 既是观察者又是被观察者
 * 它盯着Activity/Fragment的生命周期
 * 同时会通知它的观察者，通常和ViewModel一起使用
 *
 *
 * LiveData
 * mVersion 通过和mLastVersion比较，判断是否要发消息
 *
 * LiveData的粘性问题，在消息发送后注册，仍然能够收到消息，主要原因就是
 * 发消息时候mVersion++了，但新注册的mLastVersion=-1，
 */
public class LiveDataActivityLearn extends AppCompatActivity {

  private NameViewModel model;

  private TextView nameTextView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_name);
    nameTextView = findViewById(R.id.tvText);
    Button btn = findViewById(R.id.btn);

    model = new ViewModelProvider(this).get(NameViewModel.class);

    Observer<String> observer = s -> nameTextView.setText(s);

    // 订阅
    model.getCurrentName().observe(this, observer);

    btn.setOnClickListener(v -> {
      String anotherName = "Liuyang " + (model.i++);
      model.getCurrentName().postValue(anotherName);
    });

    LiveDataBus.get().getChannel("data", String.class).observe(this, new Observer<String>() {
      @Override
      public void onChanged(String s) {
        Toast.show(s);
      }
    });

    new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 10; i++) {
          // LiveData发消息通知观察者
          /**
           * 主线程中可以使用setValue，否则可以使用postValue
           */
          LiveDataBus.get().getChannel("data", String.class).postValue("Liuyang");
          try {
            Thread.sleep(5000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();
  }
}
