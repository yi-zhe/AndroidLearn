package com.liuyang.learn.jetpack.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Address {
  @PrimaryKey(autoGenerate = true)
  public int addressId;

  @ColumnInfo(name = "address")
  public String address;

  public Address(int addressId, String address) {
    this.addressId = addressId;
    this.address = address;
  }

  public int getAddressId() {
    return addressId;
  }

  public void setAddressId(int addressId) {
    this.addressId = addressId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Address{" +
        "addressId=" + addressId +
        ", address='" + address + '\'' +
        '}';
  }
}
