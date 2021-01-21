package com.liuyang.learn.jetpack.room;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class StudentViewModel extends AndroidViewModel {
  private StudentRepository studentRepository;
  public StudentViewModel(@NonNull Application application) {
    super(application);
    studentRepository = new StudentRepository(application);
  }


  void insert(Student... students) {
    studentRepository.insert(students);
  }

  void delete(Student student) {
    studentRepository.delete(student);
  }

  void update(Student student) {
    studentRepository.update(student);
  }
  List<Student> getAll() {
    return studentRepository.getAll();
  }

  LiveData<List<Student>> getAllLiveDataStudent() {
    return studentRepository.getAllLiveDataStudent();
  }
}
