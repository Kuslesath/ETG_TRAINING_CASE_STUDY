package com.sonata.springMvc1;


import java.util.List;


public interface TaskInterface {
	
	public List<Task> getAllTask();
	public List<Task> printTask(String k,String v);
	public boolean setPriority(int t,String pr);
	public boolean addTask(Task t);
	public boolean assignTask(int t,int u);
	public boolean addNotes(int t,String u);
	public boolean addBookmark(int t,String u);
	public List<Task> status(String s);
	public boolean changestatus(int t,String s,String d);
	public boolean taskdel(int t);
}