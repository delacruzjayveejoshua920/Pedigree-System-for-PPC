package com.ppc.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppc.common.dao.PrintDao;
import com.ppc.common.model.Print;
import com.ppc.common.service.PrintService;

@Service("printService")
public class PrintServiceImpl implements PrintService{
	
	@Autowired
	@Qualifier("printDao")
	private PrintDao printDao;
	
	@Override
	@Transactional
	public void addPrint(Print print){
		printDao.addPrint(print);
	}
	
	@Override
	@Transactional
	public void updatePrint(Print print){
		printDao.updatePrint(print);
	}
	
	@Override
	@Transactional
	public void deletePrint(Print print){
		printDao.deletePrint(print);
	}
	
	@Override
	@Transactional
	public Print getPrintById(int id){
		Print print = printDao.getPrintById(id);
		return print;
	}
	
	@Override
	@Transactional
	public List<Print> getAllPrints(){
		List<Print> prints = printDao.getAllPrints();
		return prints;
	}
}
