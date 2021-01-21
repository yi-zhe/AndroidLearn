package com.liuyang.learn.jetpack.room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = { Student.class }, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

  private static AppDatabase instance;

  public static synchronized AppDatabase getInstance(Context c) {
    if (instance == null) {
      instance = Room.databaseBuilder(c.getApplicationContext(),
          AppDatabase.class, "mydb")
          //.allowMainThreadQueries()
          // 强制升级 不建议 会丢失数据
          //.fallbackToDestructiveMigration()

          .addMigrations(MIGRATION_2_3)
          .build();
    }
    return instance;
  }

  public abstract StudentDao studentDao();

  static final Migration MIGRATION_1_2 = new Migration(1, 2) {
    @Override
    public void migrate(@NonNull SupportSQLiteDatabase database) {
      // 在这里用sql完成数据变化
      database.execSQL("ALTER TABLE STUDENT ADD column flag integer not null default 1");
    }
  };

  static final Migration MIGRATION_2_3 = new Migration(2, 3) {
    @Override
    public void migrate(@NonNull SupportSQLiteDatabase database) {
      // 在这里用sql完成数据变化 删字段
      // 创建临时表
      //            database.execSQL("create table student_temp (id integer primary key not null,name text,pwd text,addressId)");
      // 数据放入临时表
      //            database.execSQL("insert into student_temp (id,name,pwd,addressid)" + " select id,name,pwd,addressid from student");
      // 删除原表
      //            database.execSQL("drop table student");
      // 修改临时表名字
      //            database.execSQL("alter table student_temp rename to student");
    }
  };
}
