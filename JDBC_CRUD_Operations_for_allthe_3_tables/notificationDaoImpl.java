package com.sonata.notificationDaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sonata.dbConnection.dbConnection;
import com.sonata.notificationModel.*;

public class notificationDaoImpl {

	int row=0;
	dbConnection db = new dbConnection();
	Notification u=null;
	
	public int save(Object object) {
		try {
			u= (Notification)object;
			PreparedStatement p=db.getCon().prepareStatement("insert into notification values(?,?,?,?,?,?)");
			p.setInt(2,u.getTaskid());
			p.setInt(1,u.getNid());
			p.setInt(3,u.getTaskownerid());
			p.setString(4,u.getStatus());
			p.setString(6, u.getStatus_changed_on());
			p.setString(5, u.getCreated_on());
			row=p.executeUpdate();
			db.closeCon();
		}
		catch(Exception e) {System.out.println(e);}
		return row;
	}
	
	public List<Notification> getData(){
		 List<Notification> e1=new ArrayList<>();
		 try {
				PreparedStatement p1=db.getCon().prepareStatement("select * from notification");
				ResultSet rs=p1.executeQuery();
				while(rs.next()) {
					Notification us = new Notification();
					int taskid= rs.getInt(2);
					int taskownerid=rs.getInt(3);
					int nid=rs.getInt(1);
					String status = rs.getString(4);
					String sco = rs.getString(6);
					String createdon = rs.getString(5);

					us.setTaskid(taskid);
					us.setTaskownerid(taskownerid);
					us.setNid(nid);
					us.setStatus(status);
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
			u = (Notification)object;
			PreparedStatement p=db.getCon().prepareStatement("update notification set status=? where nid=?");
			p.setString(1,"completed");
			p.setInt(2, u.getNid());
			row=p.executeUpdate();
			db.closeCon();
		}
		catch(Exception e) {System.out.println();}
		return row;
	}
	
	public int delete(Object object) {
		try {
			u = (Notification)object;
			PreparedStatement p=db.getCon().prepareStatement("delete from notification where nid=?");
			p.setInt(1, u.getNid());
			row=p.executeUpdate();
			db.closeCon();
		}
		catch(Exception e) {System.out.println();}
		return row;
	}
}

