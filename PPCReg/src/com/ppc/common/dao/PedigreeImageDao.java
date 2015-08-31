package com.ppc.common.dao;

import java.util.List;

import com.ppc.common.model.PedigreeImage;


public interface PedigreeImageDao {
	public void addImagePedigree(PedigreeImage image);
	public PedigreeImage getImageById(int id);
	public List<PedigreeImage> getAllImages();
}
