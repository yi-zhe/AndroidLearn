package com.liuyang.learn.jetpack.room;

import android.os.Bundle;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.liuyang.learn.R;
import java.util.List;

/**
 * 1. 定义数据库
 * 2. Dao层给应用程序使用
 * 3.
 */
public class RoomLearnActivity2 extends AppCompatActivity {

  StudentViewModel studentViewModel;
  ListView listView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.room_view_model);
    listView = findViewById(R.id.listView);
    studentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);
    studentViewModel.getAllLiveDataStudent().observe(this, new Observer<List<Student>>() {
      @Override
      public void onChanged(List<Student> students) {
        listView.setAdapter(new GoodsAdapter(RoomLearnActivity2.this, students));
      }
    });

    listView.postDelayed(new Runnable() {
      @Override
      public void run() {
        StudentDao dao = AppDatabase.getInstance(RoomLearnActivity2.this).studentDao();
        dao.insert(new Student("liuyang1", "123", "1"));
        dao.insert(new Student("liuyang2", "123", "2"));
        dao.insert(new Student("liuyang3", "123", "3"));
        dao.insert(new Student("liuyang4", "123", "4"));
      }
    }, 3000);
  }
}
