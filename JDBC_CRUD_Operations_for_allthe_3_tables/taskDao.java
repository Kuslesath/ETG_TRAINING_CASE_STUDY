package com.sonata.taskDao;

import java.util.List;
import com.sonata.taskModel.Task;

public interface taskDao {

	public int save(Object object);
	public List<Task> getData();
	public int update(Object object);
	public int delete(Object object);
}
