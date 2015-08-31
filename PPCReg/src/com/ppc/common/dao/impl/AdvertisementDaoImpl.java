package com.ppc.common.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ppc.common.dao.AdvertisementDao;
import com.ppc.common.model.Advertisement;
import com.ppc.common.model.PedigreeImage;

import org.apache.log4j.Logger;

@Repository("advertisementDao")
public class AdvertisementDaoImpl implements AdvertisementDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(Advertisement.class);
	
	@Override 
	public void addAdvertisement(Advertisement advertisement) {
		//advertisement.setPedigreeimage(pedigreeImage);
		sessionFactory.getCurrentSession().save(advertisement);
		//logger.info("User with username '" + user.getUsername() + "' is added");
	}
	
	@Override 
	public void updateAdvertisement(Advertisement advertisement) {
		int count= 1;
		//advertisement.setNumberClicks(advertisement.getNumberClicks()+1);
		sessionFactory.getCurrentSession().update(advertisement);
		
		//logger.info("User with username '"+user.getUsername() +"' is updated");
	}
	
	
	
	@Override
	public void deleteAdvertisement(Advertisement advertisement) {
		sessionFactory.getCurrentSession().delete(advertisement);
		//logger.info("User with username '" + user.getUsername() + "' is deleted");
	}
	
	@Override
	public void updateAdsCounter(Advertisement advertisement){
		advertisement.setNumberClicks(advertisement.getNumberClicks() + 1);
		sessionFactory.getCurrentSession().update(advertisement);
	}
	
	@Override
	public Advertisement getAdvertisementById(int id){
		Query query = sessionFactory.getCurrentSession().createQuery("from Advertisement a WHERE a.id = :id");
		query.setLong("id", id);
		query.setMaxResults(1);
		return (Advertisement) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Advertisement> getAllAdvertisements() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Advertisement a");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Advertisement> getAllAdvertisementsbyId(long id){
		Query query = sessionFactory.getCurrentSession().createQuery("from Advertisement a left join fetch a.user u WHERE u.id = :id AND a.isApproved = :isApproved");
		query.setLong("id", id);
		query.setBoolean("isApproved", true);
		return query.list();
	}
	
	
	// Main Page -> Header
	@Override
	public Advertisement getAdvertisement(String location, String type){
		Query query = sessionFactory.getCurrentSession().createQuery("from Advertisement a WHERE TYPE_AD = :type  AND location = :location AND IS_APPROVED = :approved");
		//Query query = sessionFactory.getCurrentSession().createQuery("from Advertisement a WHERE TYPE_AD = :type or TYPE_AD = 'All'  AND location = :location AND IS_APPROVED = :approved");
		
		/*
		if(type == "Main"){
			query.setString("type", "Main");
		}
		if(type == "Subpage"){
			query.setString("type", "Subpage");
		}
		*/
		
		if(type == "Main" || type == "Subpage" || type == "All"){
			query.setString("type", type);
		}
			
		
		//query.setString("type1", "All");
		 
		if(location == "Header" || location == "Side" || location == "Footer"){
			query.setString("location", location);
		}
		/*
		if(location == "Header"){
			query.setString("location", "Header");
		}
		if(location == "Side"){
			query.setString("location", "Side");
		}
		if(location == "Footer"){
			query.setString("location", "Footer");
		}
		*/

		query.setBoolean("approved", true);
		query.setMaxResults(1);
		return (Advertisement) query.uniqueResult();
	}
	
	// Main Page -> Side
	
	
}
