package com.sonata.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
public class dbConnection {

	Connection con;
	
	public Connection getCon() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_casestudy","root","admin@123");
			}
			catch(Exception e) {
				System.out.print(e);
			}
			return con;
	}
	public void closeCon() {
		try {
			if(con !=null) {
				con.close();
			}
		}catch(Exception e) {
			System.out.print(e);
		}
	}
}
