package com.sonata.taskMain;

import java.util.ArrayList;
import java.util.List;

import com.sonata.taskDaoImpl.taskDaoImpl;
import com.sonata.taskModel.Task;

public class taskTest {
	public static void main(String args[]) throws Exception{
	
	Task e = new Task();
	e.setTaskid(1);
	e.setOwnerid(100);
	e.setCreatorid(100);
	e.setName("create_db");
	e.setDescrptn("create tables");
	e.setStatus("pending");
	e.setPriority("high");
	e.setNotes("creating tables is a important task");
	e.setBookMarked(true);
	e.setCreated_on("2021-11-11 12:23:45");
	e.setStatus_changed_on("2021-11-11 12:23:45");
	
	taskDaoImpl d= new taskDaoImpl();
	int row = d.save(e);
	System.out.println(row);
	
	List<Task> e1=new ArrayList<>();
	e1=d.getData();
	for(Task f:e1) {
		System.out.println(f.getTaskid()+" "+f.getOwnerid()+" "+f.getCreatorid()+" "+f.getName()+" " +f.getDescrptn()+" "+f.getStatus()+" "+f.getPriority()+" "+f.getNotes()+" "+f.isBookMarked()+" "+f.getCreated_on()+" "+f.getStatus_changed_on());
		System.out.println();
	}
	
	row=d.update(e);
	System.out.println(row);
	
	int row1=d.delete(e);
	System.out.println(row1);
	
	}
	
}