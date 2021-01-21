package com.liuyang.learn.jetpack.room;

import android.content.Context;
import androidx.lifecycle.LiveData;
import java.util.List;

public class StudentRepository {
  private LiveData<List<Student>> liveDataAllStudent;

  private StudentDao studentDao;

  public StudentRepository(Context c) {
    AppDatabase database = AppDatabase.getInstance(c);
    studentDao = database.studentDao();
    //if (liveDataAllStudent == null) {
    //  liveDataAllStudent = studentDao.getAllLiveDataStudent();
    //}
  }

  void insert(Student... students) {
    studentDao.insert(students);
  }

  void delete(Student student) {
    studentDao.delete(student);
  }

  void update(Student student) {
    studentDao.update(student);
  }

  List<Student> getAll() {
    return studentDao.getAll();
  }

  LiveData<List<Student>> getAllLiveDataStudent() {
    return studentDao.getAllLiveDataStudent();
  }
}
