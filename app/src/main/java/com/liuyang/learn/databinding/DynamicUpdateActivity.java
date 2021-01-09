package com.liuyang.learn.databinding;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
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
  }
}