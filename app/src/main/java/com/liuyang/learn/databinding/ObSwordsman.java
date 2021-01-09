package com.liuyang.learn.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.liuyang.learn.BR;

public class ObSwordsman extends BaseObservable {
  public String name;
  public String level;

  public ObSwordsman(String name, String level) {
    this.name = name;
    this.level = level;
  }

  @Bindable
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    notifyPropertyChanged(BR.name);
  }

  @Bindable
  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
    notifyPropertyChanged(BR.level);
  }
}
