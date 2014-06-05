package com.github.walterfan.gtd.dao;

import java.sql.SQLException;
import java.util.List;

import com.github.walterfan.gtd.model.Task;

public interface ITaskDao {
	
	void open() throws SQLException;
	
	void close();
	
	Task createTask(Task task);
	
	int updateTask(Task task);
	
	Task retrieveTask(int taskID);
	
	void deleteTask(int taskID);
	
	List<Task> getAllTasks();
	
	List<Task> getTasks(int pageNum, int pageSize);
	
	List<Task> searchTasks(String tag, long beginTime, long endTime);
}
