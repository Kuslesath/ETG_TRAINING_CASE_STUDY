package com.sonata.springMvc1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.sonata.springMvc1.Task;
import com.sonata.springMvc1.TaskInterface;
import com.sonata.springMvc1.dbConnection;

@Component
public class DefaultTask implements TaskInterface {

	public int addTask(Task u) {
		try {
			dbConnection db = new dbConnection();
			PreparedStatement p=db.getCon().prepareStatement("insert into task values(?,?,?,?,?,?,?,?,?,?,?)");
			p.setInt(1,u.getTaskid());
			p.setInt(2,u.getOwnerid());
			p.setInt(3,u.getCreatorid());
			p.setString(4,u.getName());
			p.setString(5,u.getDescrptn());
			p.setString(6,u.getStatus());
			p.setString(7,u.getPriority());
			p.setString(8, u.getName());
			p.setBoolean(9, u.isBookMarked());
			p.setString(11, u.getStatus_changed_on());
			p.setString(10, u.getCreated_on());
			return p.executeUpdate();
		}
		catch(Exception e) {System.out.println(e);}
		return 0;
	};
	
	public int assignTask(int t,int u) {
		int row=0;
		try {
			dbConnection db = new dbConnection();
			PreparedStatement p=db.getCon().prepareStatement("update task set ownerid=? where taskid=?");
			p.setInt(2, t);
			p.setInt(1, u);
			row=p.executeUpdate();
		}
		catch(Exception e) {System.out.println();}
		return row;
	}
	
	public int addNotes(int t,String u) {
		int row=0;
		try {
			dbConnection db = new dbConnection();
			PreparedStatement p=db.getCon().prepareStatement("update task set notes=? where taskid=?");
			p.setString(1, u);
			p.setInt(2, t);
			row=p.executeUpdate();
		}
		catch(Exception e) {System.out.println();}
		return row;
	}

	public int addBookmark(int t,String u) {
		int row=0;
		try {
			dbConnection db = new dbConnection();
			PreparedStatement p=db.getCon().prepareStatement("update task set isbookmarked=? where taskid=?");
			p.setString(1, u);
			p.setInt(2, t);
			row=p.executeUpdate();
		}
		catch(Exception e) {System.out.println();}
		return row;
	}
	
	@Override
	public List<Task> getAllTask() {
		dbConnection db = new dbConnection();
		List<Task> e1=new ArrayList<>();
		 try {
				PreparedStatement p1=db.getCon().prepareStatement("select * from task");
				ResultSet rs=p1.executeQuery();
				while(rs.next()) {
					Task us = new Task();
					int taskid= rs.getInt(1);
					int ownerid=rs.getInt(2);
					int creatorid=rs.getInt(3);
					String name= rs.getString(4);
					String descrptn = rs.getString(5);
					String status = rs.getString(6);
					String priority = rs.getString(7);
					String notes = rs.getString(8);
					Boolean isbm = rs.getBoolean(9);
					String sco = rs.getString(11);
					String createdon = rs.getString(10);

					us.setTaskid(taskid);
					us.setOwnerid(ownerid);
					us.setCreatorid(creatorid);
					us.setName(name);
					us.setDescrptn(descrptn);
					us.setStatus(status);
					us.setPriority(priority);
					us.setNotes(notes);
					us.setBookMarked(isbm);
					us.setStatus_changed_on(sco);
					us.setCreated_on(createdon);
					
					e1.add(us);
				}
		 	}
			catch(Exception e) {System.out.println();}
		 	return e1;
	}
	public List<Task> printTask(int t){
		dbConnection db = new dbConnection();
		List<Task> e1=new ArrayList<>();
		 try {
				PreparedStatement p1=db.getCon().prepareStatement("select * from task where taskid=?");
				p1.setInt(1, t);
				ResultSet rs=p1.executeQuery();
				while(rs.next()) {
					Task us = new Task();
					int taskid= rs.getInt(1);
					int ownerid=rs.getInt(2);
					int creatorid=rs.getInt(3);
					String name= rs.getString(4);
					String descrptn = rs.getString(5);
					String status = rs.getString(6);
					String priority = rs.getString(7);
					String notes = rs.getString(8);
					Boolean isbm = rs.getBoolean(9);
					String sco = rs.getString(11);
					String createdon = rs.getString(10);

					us.setTaskid(taskid);
					us.setOwnerid(ownerid);
					us.setCreatorid(creatorid);
					us.setName(name);
					us.setDescrptn(descrptn);
					us.setStatus(status);
					us.setPriority(priority);
					us.setNotes(notes);
					us.setBookMarked(isbm);
					us.setStatus_changed_on(sco);
					us.setCreated_on(createdon);
					
					e1.add(us);
				}
		 	}
			catch(Exception e) {System.out.println();}
		 	return e1;
	}
	public int setPriority(int t,String pr) {
		int row=0;
		try {
			dbConnection db = new dbConnection();
			PreparedStatement p=db.getCon().prepareStatement("update task set priority=? where taskid=?");
			p.setInt(2, t);
			p.setString(1, pr);
			row=p.executeUpdate();
			db.closeCon();
		}
		catch(Exception e) {System.out.println();}
		return row;
	}
	
	public List<Task> status(String s){
		dbConnection db = new dbConnection();
		List<Task> e1=new ArrayList<>();
		 try {
				PreparedStatement p1=db.getCon().prepareStatement("select * from task where status=?");
				p1.setString(1, s);
				ResultSet rs=p1.executeQuery();
				
				while(rs.next()) {
					Task us = new Task();
					int taskid= rs.getInt(1);
					int ownerid=rs.getInt(2);
					int creatorid=rs.getInt(3);
					String name= rs.getString(4);
					String descrptn = rs.getString(5);
					String status = rs.getString(6);
					String priority = rs.getString(7);
					String notes = rs.getString(8);
					Boolean isbm = rs.getBoolean(9);
					String sco = rs.getString(11);
					String createdon = rs.getString(10);

					us.setTaskid(taskid);
					us.setOwnerid(ownerid);
					us.setCreatorid(creatorid);
					us.setName(name);
					us.setDescrptn(descrptn);
					us.setStatus(status);
					us.setPriority(priority);
					us.setNotes(notes);
					us.setBookMarked(isbm);
					us.setStatus_changed_on(sco);
					us.setCreated_on(createdon);
					
					e1.add(us);
				}
		 	}
			catch(Exception e) {System.out.println();}
		 	return e1;
		
	}

}
