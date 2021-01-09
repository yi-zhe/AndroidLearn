package com.liuyang.learn.databinding;

public class Swordsman {
  public String name;
  public String level;

  public Swordsman(String name, String level) {
    this.name = name;
    this.level = level;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }
}
