package com.liuyang.learn.databinding;

import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

public class ObfSwordsman {
  public ObservableField<String> name = new ObservableField<>();
  public ObservableField<String> level = new ObservableField<>();

  public ObfSwordsman(String name, String level) {
    this.name.set(name);
    this.level.set(level);
  }

  public ObservableField<String> getName() {
    return name;
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public ObservableField<String> getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level.set(level);
  }
}
