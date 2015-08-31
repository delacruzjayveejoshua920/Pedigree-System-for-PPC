package com.ppc.common.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ppc.common.dao.UserDao;
import com.ppc.common.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(UserDao.class);
	
	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		logger.info("User with username '" + user.getUsername() + "' is added");
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		logger.info("User with username '"+user.getUsername() +"' is updated");
	}


	@Override
	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
		logger.info("User with username '" + user.getUsername() + "' is deleted");
	}
	
	@Override
	public User getUserById(long id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User u WHERE u.id = :id");
		query.setLong("id", id);
		query.setMaxResults(1);
		return (User) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		Query query = sessionFactory.getCurrentSession().createQuery("from User u");
		return query.list();
	}
	
	@Override
	public User verifyUser(String username, String password){
		Query query = sessionFactory.getCurrentSession().createQuery("from User u WHERE u.username = :username AND u.password = :password");
		query.setString("username", username);
		query.setString("password", password);
		query.setMaxResults(1);
		return (User) query.uniqueResult();
	}
	
	@Override
	public User getUserByUsername(String username){
		Query query = sessionFactory.getCurrentSession().createQuery("from User u WHERE u.username = :username");
		query.setString("username", username);
		query.setMaxResults(1);
		return (User) query.uniqueResult();
	}

}
