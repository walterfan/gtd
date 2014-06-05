package com.github.walterfan.gtd.dao;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.github.walterfan.gtd.R;

public class TaskDaoHelper extends SQLiteOpenHelper {
	public static final String TABLE_NAME = "wftask";

	//taskid,taskname,priority,deadline,duration,finish,comments,createtime,lastmodifiedtime
	private static final String TAG = TaskDaoHelper.class.getSimpleName();
	private static final String DATABASE_NAME = "gtd.db";
	private static final int DATABASE_VERSION = 1;
	
	private Context mContext;
	private String[] mColumns;
	
	public static ITaskDao createTaskDao() {
		return new SQLiteTaskDao();
	}

	public String[] getColumns() {
		return this.mColumns;
	}
	
	public void setColumns(String columns) {
		if(columns == null)
			columns = mContext.getString(R.string.TaskTableColumns);
		mColumns = columns.split(",");
	}
	
	public TaskDaoHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.mContext = context;
		setColumns(null);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String[] sqls = mContext.getString(R.string.TaskDatabase_onCreate)
				.split("\n");
		db.beginTransaction();
		try {
			execMultipleSql(db, sqls);
			db.setTransactionSuccessful();
		} catch (SQLException e) {
			Log.e(TAG, "create db error: " + e.getMessage());			
		} finally {
			db.endTransaction();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String[] sqls = mContext.getString(R.string.TaskDatabase_onUpgrade)
				.split("\n");
		
		db.beginTransaction();
		try {
			execMultipleSql(db, sqls);
			db.setTransactionSuccessful();
		} catch (SQLException e) {
			Log.e(TAG,  "upgrade db error: " +  e.getMessage());			
		} finally {
			db.endTransaction();
		}
		
		onCreate(db);
	}

	private void execMultipleSql(SQLiteDatabase db, String[] sqls) throws SQLException {
		for (String sql : sqls) {
			if (null != sql && sql.trim().length() > 0) {
				db.execSQL(sql);
			}
		}
	}
}