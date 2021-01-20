package com.liuyang.learn.jetpack.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface StudentDao {
  @Insert
  void insert(Student... students);

  @Delete
  void delete(Student student);

  @Update
  void update(Student student);

  @Query("SELECT * FROM STUDENT")
  List<Student> getAll();

  // 条件查询
  @Query("SELECT * FROM STUDENT WHERE name like :name")
  Student findByName(String name);

  @Query("SELECT * FROM STUDENT WHERE id in(:userIds)")
  List<Student> findAllId(int[] userIds);

  @Query("SELECT name, password FROM STUDENT")
  List<StudentTuple> getRecord();

  //@Query("SELECT X, X, X FROM  WHERE STUDENT.X==ADDRESS.X")
}
