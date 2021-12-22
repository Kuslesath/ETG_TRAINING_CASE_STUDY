package com.sonata.springMvc1;

import java.sql.SQLException;
import java.util.List;

public interface UserInterface {

	public boolean addUser(User u);
	public boolean login(String u, String p) throws SQLException;
	public List<User> getAllUsers();
}
