package com.sonata.springMvc1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.sonata.springMvc1.User;
import com.sonata.springMvc1.UserInterface;
import com.sonata.springMvc1.dbConnection;

@Component
public class DefaultUser implements UserInterface {
	dbConnection db = new dbConnection();
	public boolean addUser(User u) {
		int row=0;
		boolean f=false;
		try {
			
			PreparedStatement p=db.getCon().prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?,?)");
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
			p.setString(11, u.getPwd() );
			row=p.executeUpdate();
			
		}
		catch(Exception e) {System.out.println(e);}
		if( row==0) {
			return false;
		}
		else return true;
	}
	public boolean login(String u, String p) throws SQLException{
		 
				PreparedStatement p1=db.getCon().prepareStatement("select * from user where username=? and pwd=?");
				p1.setString(1, u);
				p1.setString(2, p);
				ResultSet rs=p1.executeQuery();
				if(rs.next()) {
					return true;
				}
				else return false;				
	}
	public List<User> getAllUsers(){
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
				Long phno = rs.getLong(6);
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
		catch(Exception e) {System.out.println(e);}
	 	return e1;
}
}
