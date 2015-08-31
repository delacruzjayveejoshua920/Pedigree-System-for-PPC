package com.ppc.common.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppc.common.dao.UserDao;
import com.ppc.common.model.User;
import com.ppc.common.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Override
	@Transactional
	public void addUser(User user) {
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		userDao.addUser(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	@Override
	@Transactional
	public User getUserById(long id) {
		User user = userDao.getUserById(id);
		return user;
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		List<User> users = userDao.getAllUsers();
		return users;
	}
	
	@Override
	@Transactional
	public User getUserCredentials(String username, String password){
		User users = userDao.verifyUser(username,password);	
	    return users;
	}
	
	@Override
	@Transactional
	public User getUserByUsername(String username){
		User user = userDao.getUserByUsername(username);
		return user;
	}

}
