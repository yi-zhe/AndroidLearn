package com.liuyang.learn.jetpack.room;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.List;

/**
 * 1. 定义数据库
 * 2. Dao层给应用程序使用
 * 3.
 */
public class RoomLearnActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DbTest dbTest = new DbTest();
    dbTest.start();
  }

  public class DbTest extends Thread {
    @Override
    public void run() {
      AppDatabase database = Room.databaseBuilder(getApplicationContext(),
          AppDatabase.class, "students").build();

      StudentDao dao = database.studentDao();
      dao.insert(new Student("liuyang1", "123", "1"));
      dao.insert(new Student("liuyang2", "123", "2"));
      dao.insert(new Student("liuyang3", "123", "3"));
      dao.insert(new Student("liuyang4", "123", "4"));

      List<Student> students = dao.getAll();
      Log.i("==##", students.toString());

      Student l2 = dao.findByName("liuyang2");
      Log.i("==##", l2.toString());

      List<Student> allId = dao.findAllId(new int[] { 1, 2 });
      Log.i("==##", allId.toString());

      List<StudentTuple> tuples = dao.getRecord();
      Log.i("==##", tuples.toString());
    }
  }
}
