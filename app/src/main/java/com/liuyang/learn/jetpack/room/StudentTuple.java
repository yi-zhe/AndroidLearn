package com.liuyang.learn.jetpack.room;

import androidx.room.ColumnInfo;

public class StudentTuple {

  @ColumnInfo(name = "name")
  private String name;

  @ColumnInfo(name = "password")
  private String password;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Student{" +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
