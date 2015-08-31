package com.ppc.common.dao;

import java.util.List;

import com.ppc.common.model.Pedigree;
import com.ppc.common.model.PedigreeImage;

public interface PedigreeDao {
	public void addPedigree(Pedigree pedigree);
	public void updatePedigree(Pedigree pedigree);
	public void deletePedigree(Pedigree pedigree);
	public Pedigree getPedigreeById(long id);
	public List<Pedigree> getAllSire();
	public List<Pedigree> getAllDam();
	public List<Pedigree> getAllPedigrees();
	public List<Pedigree> getAllPedigreeById(Pedigree pedigree);
	public List<Pedigree> getAllPedigreeDisapprove();
	public List<Pedigree> getAllPedigreeByKeyword(String keyword);
}
