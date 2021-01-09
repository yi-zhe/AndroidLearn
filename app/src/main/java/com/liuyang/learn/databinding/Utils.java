package com.liuyang.learn.databinding;

import androidx.databinding.BindingConversion;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

  public static String getName(Swordsman man) {
    return man.getName();
  }

  // 在哪不重要，重要的是注解
  @BindingConversion
  public static String convertDate(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(date);
  }
}
