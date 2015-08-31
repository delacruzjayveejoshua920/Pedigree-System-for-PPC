package com.ppc.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppc.common.dao.PedigreeDao;
import com.ppc.common.model.Advertisement;
import com.ppc.common.model.Pedigree;
import com.ppc.common.model.PedigreeImage;
import com.ppc.common.model.User;
import com.ppc.common.service.PedigreeService;

@Service("pedigreeService")
public class PedigreeServiceImpl implements PedigreeService{
	
	@Autowired
	@Qualifier("pedigreeDao")
	private PedigreeDao pedigreeDao;
	
	
	@Override
	@Transactional
	public void addPedigree(Pedigree pedigree){
		pedigreeDao.addPedigree(pedigree);
	}
	
	@Override
	@Transactional
	public void updatePedigree(Pedigree pedigree){
		pedigreeDao.updatePedigree(pedigree);
	}
	
	@Override
	@Transactional
	public void deletePedigree(Pedigree pedigree){
		pedigreeDao.deletePedigree(pedigree);
	}
	
	@Override
	@Transactional
	public Pedigree getPedigreeById(long id){
		Pedigree pedigree = pedigreeDao.getPedigreeById(id);
		return pedigree;
	}
	
	@Override
	@Transactional
	public List<Pedigree> getAllSire(){
		List<Pedigree> sires = pedigreeDao.getAllSire();
		return sires;
	}
	
	@Override
	@Transactional
	public List<Pedigree> getAllDam(){
		List<Pedigree> dams = pedigreeDao.getAllDam();
		return dams;
	}
	
	@Override
	@Transactional
	public List<Pedigree> getAllPedigrees(){
		List<Pedigree> pedigrees = pedigreeDao.getAllPedigrees();
		return pedigrees;
	}
	
	@Override
	@Transactional
	public List<Pedigree> getAllPedigreeById(Pedigree pedigree){
		List<Pedigree> pedigrees = pedigreeDao.getAllPedigreeById(pedigree);
		return pedigrees;
	}
	
	@Override
	@Transactional
	public List<Pedigree> getAllPedigreeDisapprove(){
		List<Pedigree> pedigreeDisapprove = pedigreeDao.getAllPedigreeDisapprove();
		return pedigreeDisapprove;
	}
	
	@Override
	@Transactional
	public List<Pedigree> getAllPedigreeByKeyword(String keyword){
		List<Pedigree> pedigreeResult = pedigreeDao.getAllPedigreeByKeyword(keyword);
		return pedigreeResult;
	}
}
