package com.ppc.common.dao;

import java.util.List;

import com.ppc.common.model.Print;

public interface PrintDao {
	public void addPrint(Print print);	
	public void updatePrint(Print print);
	public void deletePrint(Print print);
	public Print getPrintById(int id);
	public List<Print> getAllPrints();
}
