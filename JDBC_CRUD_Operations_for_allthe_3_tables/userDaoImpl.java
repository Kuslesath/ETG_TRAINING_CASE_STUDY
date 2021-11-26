package com.sonata.userDaoImpl;

import java.sql.*;
import java.util.*;
import com.sonata.userModel.*;
import com.sonata.userDao.*;
import com.sonata.dbConnection.*;

public class userDaoImpl implements userDao{
	int row=0;
	dbConnection db = new dbConnection();
	User u=null;
	
	public int save(Object object) {
		try {
			u= (User)object;
			PreparedStatement p=db.getCon().prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?)");
			p.setInt(1,u.getUserid());
			p.setString(2,u.getUsername());
			p.setString(3,u.getEmail());
			p.setString(4,u.getFname());
			p.setString(5,u.getLname());
			p.setLong(6, u.getPhno());
			p.setString(7, u.getRole());
			p.setBoolean(8, u.isIsactive());
			p.setString(9, u.getDob());
			p.setString(10, u.getCreated_on());
			row=p.executeUpdate();
			db.closeCon();
		}
		catch(Exception e) {System.out.println(e);}
		return row;
	}
	
	public List<User> getData(){
		 List<User> e1=new ArrayList<>();
		 try {
				PreparedStatement p1=db.getCon().prepareStatement("select * from user");
				ResultSet rs=p1.executeQuery();
				while(rs.next()) {
					User us = new User();
					int uid= rs.getInt(1);
					String uname= rs.getString(2);
					String uemail = rs.getString(3);
					String ufname = rs.getString(4);
					String ulname = rs.getString(5);
					int phno = rs.getInt(6);
					String role = rs.getString(7);
					Boolean isactive = rs.getBoolean(8);
					String dob = rs.getString(9);
					String createdon = rs.getString(10);

					us.setUserid(uid);
					us.setUsername(uname);
					us.setEmail(uemail);
					us.setFname(ufname);
					us.setLname(ulname);
					us.setPhno(phno);
					us.setRole(role);
					us.setIsactive(isactive);
					us.setDob(dob);
					us.setCreated_on(createdon);
					
					e1.add(us);
				}
		 	}
			catch(Exception e) {System.out.println();}
		 	return e1;
	}
	public int update(Object object) {
		try {
			u = (User)object;
			PreparedStatement p=db.getCon().prepareStatement("update user set username=? where userid=?");
			p.setString(1,"kushal");
			p.setInt(2, u.getUserid());
			row=p.executeUpdate();
			db.closeCon();
		}
		catch(Exception e) {System.out.println();}
		return row;
	}
	
	public int delete(Object object) {
		try {
			u = (User)object;
			PreparedStatement p=db.getCon().prepareStatement("delete from user where userid=?");
			p.setInt(1, u.getUserid());
			row=p.executeUpdate();
			db.closeCon();
		}
		catch(Exception e) {System.out.println();}
		return row;
	}
}

