package com.ppc.common.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ppc.common.dao.PedigreeDao;
import com.ppc.common.model.Pedigree;
import com.ppc.common.model.PedigreeImage;
import com.sun.istack.internal.logging.Logger;

@Repository("pedigreeDao")
public class PedigreeDaoImpl implements PedigreeDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(PedigreeDao.class);
	
	@Override
	public void addPedigree(Pedigree pedigree) {
		//pedigree.setPedigreeimage(pedigreeImage);
		//pedigreeImage.setPedigree(pedigree);
		sessionFactory.getCurrentSession().save(pedigree);
		//sessionFactory.getCurrentSession().save(pedigreeImage);
		//logger.info("User with username '" + user.getUsername() + "' is added");
	}
	
	@Override
	public void updatePedigree(Pedigree pedigree) {
		sessionFactory.getCurrentSession().update(pedigree);
		//logger.info("User with username '"+user.getUsername() +"' is updated");
	}
	
	@Override
	public void deletePedigree(Pedigree pedigree){
		sessionFactory.getCurrentSession().delete(pedigree);
	}
	
	@Override
	public Pedigree getPedigreeById(long id){
		Query query = sessionFactory.getCurrentSession().createQuery("from Pedigree p WHERE p.id = :id");
		query.setLong("id", id);
		query.setMaxResults(1);
		return (Pedigree) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedigree> getAllSire(){
		Query query = sessionFactory.getCurrentSession().createQuery("from Pedigree p WHERE p.sex = 'male'");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedigree> getAllDam(){
		Query query = sessionFactory.getCurrentSession().createQuery("from Pedigree p WHERE p.sex = 'female'");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedigree> getAllPedigrees(){
		Query query = sessionFactory.getCurrentSession().createQuery("from Pedigree p");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedigree> getAllPedigreeById(Pedigree pedigree){
		StringBuffer hqlQuery = new StringBuffer(
				"from Pedigree p left join fetch p.user u  WHERE p.isApproved = :isApproved ");
		
		if(pedigree.getName() != null){
			if(!pedigree.getName().isEmpty()){
				hqlQuery.append("and lower(p.name) like lower(:search) ");
			}
		}
		
		final String queryList = hqlQuery.toString();
		Query query = sessionFactory.getCurrentSession().createQuery(queryList);
		query.setBoolean("isApproved", true);
		
		if(pedigree.getName() != null){
			if(!pedigree.getName().isEmpty()){
				query.setParameter("search", "%" + pedigree.getName() + "%");
			}
		}
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedigree> getAllPedigreeDisapprove(){
		Query query = sessionFactory.getCurrentSession().createQuery("from Pedigree p WHERE isApproved = :isApproved");
		query.setBoolean("isApproved", false);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedigree> getAllPedigreeByKeyword(String keyword){
		Query query = sessionFactory.getCurrentSession().createQuery("from Pedigree p where p.name LIKE :keyword");
		query.setParameter("keyword", "%"+keyword+"%");
		//Query query = sessionFactory.getCurrentSession().createQuery("from Pedigree p where str(p.id) like :keyword");
		//query.setString("keyword", keyword);
		return query.list();
	}
	
}
