package com.ppc.common.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ppc.common.dao.PrintDao;
import com.ppc.common.model.Advertisement;
import com.ppc.common.model.Print;

@Repository("printDao")
public class PrintDaoImpl implements PrintDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(Advertisement.class);
	
	@Override 
	public void addPrint(Print print) {
		sessionFactory.getCurrentSession().save(print);
	}
	
	@Override 
	public void updatePrint(Print print) {
		sessionFactory.getCurrentSession().update(print);
		//logger.info("User with username '"+user.getUsername() +"' is updated");
	}
	
	@Override
	public void deletePrint(Print print) {
		sessionFactory.getCurrentSession().delete(print);
		//logger.info("User with username '" + user.getUsername() + "' is deleted");
	}
	
	@Override
	public Print getPrintById(int id){
		Query query = sessionFactory.getCurrentSession().createQuery("from Print p WHERE p.id = :id");
		query.setLong("id", id);
		query.setMaxResults(1);
		return (Print) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Print> getAllPrints() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Print p");
		return query.list();
	}
}
