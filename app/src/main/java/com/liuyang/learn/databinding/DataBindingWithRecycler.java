package com.liuyang.learn.databinding;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.liuyang.learn.R;
import java.util.ArrayList;
import java.util.List;

public class DataBindingWithRecycler extends AppCompatActivity {
  private DataBindingRecyclerBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.data_binding_recycler);
    initRecycler();
  }

  private void initRecycler() {
    LinearLayoutManager manager = new LinearLayoutManager(this);
    binding.recycler.setLayoutManager(manager);
    SwordsmanAdapter adapter = new SwordsmanAdapter(getList());
    binding.recycler.setAdapter(adapter);
  }

  private List<Swordsman> getList() {
    List<Swordsman> list = new ArrayList<>();
    Swordsman s1 = new Swordsman("杨2", "SS");
    Swordsman s2 = new Swordsman("月", "A");
    Swordsman s3 = new Swordsman("月2", "A2");
    list.add(s1);
    list.add(s2);
    list.add(s3);
    return list;
  }
}