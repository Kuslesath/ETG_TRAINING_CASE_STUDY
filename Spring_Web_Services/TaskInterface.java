package com.sonata.springMvc1;


import java.util.List;


public interface TaskInterface {
	
	public List<Task> getAllTask();
	public List<Task> printTask(int t);
	public int setPriority(int t,String pr);
	public int addTask(Task t);
	public int assignTask(int t,int u);
	public int addNotes(int t,String u);
	public int addBookmark(int t,String u);
	public List<Task> status(String s);
}