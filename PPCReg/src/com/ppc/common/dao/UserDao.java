package com.ppc.common.dao;

import java.util.List;

import com.ppc.common.model.User;


public interface UserDao {
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public User getUserById(long id);
	public List<User> getAllUsers();
	public User verifyUser(String username, String password);
	public User getUserByUsername(String username);
}
