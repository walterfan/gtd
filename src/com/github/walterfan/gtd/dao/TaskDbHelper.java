package com.github.walterfan.gtd.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TaskDbHelper extends SQLiteOpenHelper {

  public static final String TASK_TABLE = "tasks";
  public static final String TASK_ID = "taskid";
  public static final String TASK_NAME = "taskname";

  private static final String DATABASE_NAME = "tasks.db";
  private static final int DATABASE_VERSION = 1;

  // Database creation sql statement
  private static final String DATABASE_CREATE = "create table "
      + TASK_TABLE + "(" + TASK_ID
      + " integer primary key autoincrement, " + TASK_NAME
      + " text not null);";

  public TaskDbHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
    database.execSQL(DATABASE_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.w(TaskDbHelper.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TASK_TABLE);
    onCreate(db);
  }

} 