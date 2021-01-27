package com.liuyang.learn.jetpack.paging;

public class Student {
  public String id;
  public String name;
  public String sex;

  public Student(String id, String name, String sex) {
    this.id = id;
    this.name = name;
    this.sex = sex;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", sex='" + sex + '\'' +
        '}';
  }
}
