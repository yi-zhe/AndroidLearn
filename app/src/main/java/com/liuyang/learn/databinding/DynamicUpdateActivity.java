package com.liuyang.learn.databinding;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import com.liuyang.learn.R;
import java.util.Date;

public class DynamicUpdateActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DataBindingUpdateBinding binding =
        DataBindingUtil.setContentView(this, R.layout.data_binding_update);
    binding.setObswordsman(new ObSwordsman("任我行", "A"));
    binding.update.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        binding.getObswordsman().setName("石破天");
      }
    });

    binding.setObfswordsman(new ObfSwordsman("任我行aa", "Aaa"));
    binding.update2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        binding.getObfswordsman().setName("石破天2");
      }
    });
    binding.update3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        binding.setList(new ObservableArrayList<>());
        binding.getList().add(new Swordsman("liuyang", "SSS"));
      }
    });

    binding.update5.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        binding.getObswordsman().setName("任我行");
      }
    });
  }
}