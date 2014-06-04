package com.github.walterfan.gtd.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Comment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.github.walterfan.gtd.model.Task;

public class SQLiteTaskDao implements ITaskDao {
	// Database fields
	private SQLiteDatabase database;
	private TaskDbHelper dbHelper;
	private String[] allColumns = { TaskDbHelper.TASK_ID,
			TaskDbHelper.TASK_NAME };//...

	public SQLiteTaskDao() {
		// TODO Auto-generated constructor stub
	}

	public SQLiteTaskDao(Context context) {
		dbHelper = new TaskDbHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
/*
	  public void deleteComment(Comment comment) {
	    long id = comment.getId();
	    System.out.println("Comment deleted with id: " + id);
	    database.delete(MySQLiteHelper.TABLE_COMMENTS, MySQLiteHelper.COLUMN_ID
	        + " = " + id, null);
	  }

	  public List<Comment> getAllComments() {
	    List<Comment> comments = new ArrayList<Comment>();

	    Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
	        allColumns, null, null, null, null, null);

	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	      Comment comment = cursorToComment(cursor);
	      comments.add(comment);
	      cursor.moveToNext();
	    }
	    // make sure to close the cursor
	    cursor.close();
	    return comments;
	  }

	  private Comment cursorToComment(Cursor cursor) {
	    Comment comment = new Comment();
	    comment.setId(cursor.getLong(0));
	    comment.setComment(cursor.getString(1));
	    return comment;
	  }
	*/
	@Override
	public int createTask(Task task) {
	    /*ContentValues values = new ContentValues();
	    values.put(MySQLiteHelper.COLUMN_COMMENT, comment);
	    long insertId = database.insert(MySQLiteHelper.TABLE_COMMENTS, null,
	        values);
	    Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
	        allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
	        null, null, null);
	    cursor.moveToFirst();
	    Comment newComment = cursorToComment(cursor);
	    cursor.close();
	    return newComment;*/
		return 0;
	}

	@Override
	public int updateTask(Task task) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int retrieveTask(int taskID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delTask(int taskID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return null;
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
