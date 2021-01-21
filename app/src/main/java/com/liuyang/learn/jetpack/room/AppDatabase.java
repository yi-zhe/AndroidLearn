package com.liuyang.learn.jetpack.room;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = { Student.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

  private static AppDatabase instance;

  public static synchronized AppDatabase getInstance(Context c) {
    if (instance == null) {
      instance = Room.databaseBuilder(c.getApplicationContext(),
          AppDatabase.class, "mydb")
          .allowMainThreadQueries()
          .build();
    }
    return instance;
  }

  public abstract StudentDao studentDao();
}
