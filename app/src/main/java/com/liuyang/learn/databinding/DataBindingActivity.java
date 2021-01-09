package com.liuyang.learn.databinding;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.liuyang.learn.R;
import java.util.Date;

public class DataBindingActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DataBindingBasicBinding binding =
        DataBindingUtil.setContentView(this, R.layout.data_binding_basic);
    Swordsman swordsman = new Swordsman("张无忌", "S");
    binding.setSwordsman(swordsman);

    // 第一种方法设置点击事件
    //binding.btNext.setOnClickListener(new View.OnClickListener() {
    //  @Override
    //  public void onClick(View v) {
    //    Toast.makeText(DataBindingActivity.this, "方法一", Toast.LENGTH_SHORT).show();
    //  }
    //});

    // 第二种方法设置点击事件
    //binding.setSecondClick(new View.OnClickListener() {
    //  @Override
    //  public void onClick(View v) {
    //    Toast.makeText(DataBindingActivity.this, "方法二", Toast.LENGTH_SHORT).show();
    //  }
    //});

    // BindingConversion
    binding.setTime(new Date());
  }
}