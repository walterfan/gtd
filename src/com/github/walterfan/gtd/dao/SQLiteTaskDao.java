package com.github.walterfan.gtd.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.github.walterfan.gtd.model.Task;

public class SQLiteTaskDao implements ITaskDao {
	// Database fields
	private SQLiteDatabase database;
	private TaskDaoHelper dbHelper;

	public SQLiteTaskDao() {
		// TODO Auto-generated constructor stub
	}

	public SQLiteTaskDao(Context context) {
		dbHelper = new TaskDaoHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	@Override
	public Task createTask(Task task) {
		ContentValues values = new ContentValues();
		values.put("taskname", task.getTaskName());
		values.put("priority", task.getPriority());
		
		long insertId = database.insert(TaskDaoHelper.TABLE_NAME, null, values);
		Cursor cursor = database.query(TaskDaoHelper.TABLE_NAME,
				dbHelper.getColumns(), "taskid" + " = " + insertId, null, null,
				null, null);
		cursor.moveToFirst();
		Task aTask = cursorToTask(cursor);
		cursor.close();
		return aTask;

	}

	private Task cursorToTask(Cursor cursor) {
		Task task = new Task();
		task.setTaskID(cursor.getInt(0));
		task.setTaskName(cursor.getString(1));
		task.setPriority(cursor.getInt(2));
		return task;
	}

	@Override
	public int updateTask(Task task) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Task retrieveTask(int taskID) {
		Cursor cursor = database.query(TaskDaoHelper.TABLE_NAME,
				dbHelper.getColumns(), "taskid" + " = " + taskID, null, null,
				null, null);
		cursor.moveToFirst();
		Task aTask = cursorToTask(cursor);
		cursor.close();
		return aTask;
	}

	@Override
	public void deleteTask(int taskID) {
		database.delete(TaskDaoHelper.TABLE_NAME, "taskid" + " = " + taskID,
				null);
	}

	@Override
	public List<Task> getAllTasks() {

		List<Task> tasks = new ArrayList<Task>(20);

		Cursor cursor = database.query(TaskDaoHelper.TABLE_NAME,
				dbHelper.getColumns(), null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Task task = cursorToTask(cursor);
			tasks.add(task);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return tasks;
	}

	@Override
	public List<Task> getTasks(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> searchTasks(String tag, long beginTime, long endTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
