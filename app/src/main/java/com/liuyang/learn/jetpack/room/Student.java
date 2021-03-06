package com.liuyang.learn.jetpack.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity()
public class Student {
  @PrimaryKey(autoGenerate = true)
  private int id;

  @ColumnInfo(name = "name")
  private String name;

  @ColumnInfo(name = "password")
  private String password;

  @ColumnInfo(name = "addressId")
  private String addressId;

  //@ColumnInfo(name = "flag")
  //private boolean flag;
  //
  //public boolean isFlag() {
  //  return flag;
  //}
  //
  //public void setFlag(boolean flag) {
  //  this.flag = flag;
  //}

  public Student(String name, String password, String addressId) {
    this.name = name;
    this.password = password;
    this.addressId = addressId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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

  public String getAddressId() {
    return addressId;
  }

  public void setAddressId(String addressId) {
    this.addressId = addressId;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", addressId='" + addressId + '\'' +
        '}';
  }
}
