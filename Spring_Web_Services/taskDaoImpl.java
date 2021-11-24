package com.sonata.springMvc1;

import java.sql.*;
import java.util.*;

public class taskDaoImpl implements taskDao{
	
	int row=0;
	dbConnection db = new dbConnection();
	Task u=null;
	
	public int save(Object object) {
		try {
			u= (Task)object;
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
			row=p.executeUpdate();
			db.closeCon();
		}
		catch(Exception e) {System.out.println(e);}
		return row;
	}
	
	public List<Task> getData(){
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
	public int update(Object object) {
		try {
			u = (Task)object;
			PreparedStatement p=db.getCon().prepareStatement("update task set status=? where taskid=?");
			p.setString(1,"completed");
			p.setInt(2, u.getTaskid());
			row=p.executeUpdate();
			db.closeCon();
		}
		catch(Exception e) {System.out.println();}
		return row;
	}
	public int delete(Object object) {
		try {
			u = (Task)object;
			PreparedStatement p=db.getCon().prepareStatement("delete from task where taskid=?");
			p.setInt(1, u.getTaskid());
			row=p.executeUpdate();
			db.closeCon();
		}
		catch(Exception e) {System.out.println();}
		return row;
	}
}
