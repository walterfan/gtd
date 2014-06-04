package com.github.walterfan.gtd.dao;

import java.sql.SQLException;
import java.util.List;

import com.github.walterfan.gtd.model.Task;

public interface ITaskDao {
	
	void open() throws SQLException;
	
	void close();
	
	int createTask(Task task);
	
	int updateTask(Task task);
	
	int retrieveTask(int taskID);
	
	int delTask(int taskID);
	
	List<Task> getAllTasks();
	
	List<Task> getTasks(int pageNum, int pageSize);
	
	List<Task> searchTasks(String tag, long beginTime, long endTime);
}
