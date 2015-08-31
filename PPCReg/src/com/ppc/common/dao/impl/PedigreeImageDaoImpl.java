package com.ppc.common.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ppc.common.dao.PedigreeImageDao;
import com.ppc.common.model.PedigreeImage;

@Repository("pedigreeImageDao")
public class PedigreeImageDaoImpl implements PedigreeImageDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(PedigreeImageDao.class);
	
	@Override
	public void addImagePedigree(PedigreeImage image) {
		sessionFactory.getCurrentSession().save(image);
		logger.info("Image with file name: "+ image.getFileName() +"is uploaded");
	}

	@Override
	public PedigreeImage getImageById(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from PedigreeImage pi WHERE pi.id = :id");
		query.setLong("id", id);
		query.setMaxResults(1);
		
		return (PedigreeImage) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PedigreeImage> getAllImages() {
		Query query = sessionFactory.getCurrentSession().createQuery("from PedigreeImage pi");
		return query.list();
	}

}
