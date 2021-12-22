package com.sonata.springMvc1;

import java.util.List;

public interface taskDao {

	public int save(Object object);
	public List<Task> getData();
	public int update(Object object);
	public int delete(Object object);
}
