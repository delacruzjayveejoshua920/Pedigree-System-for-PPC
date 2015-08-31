package com.ppc.common.service;

import java.util.List;

import com.ppc.common.model.User;

public interface UserService {
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public User getUserById(long id);
	public List<User> getAllUsers();
	public User getUserCredentials(String username, String password);
	public User getUserByUsername(String username);
}
