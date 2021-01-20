package com.liuyang.learn.jetpack.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = { Student.class, Address.class }, version = 2)
public abstract class AppDatabase extends RoomDatabase {
  public abstract StudentDao studentDao();
}
