package com.ppc.common.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ppc.common.model.PedigreeImage;

public interface PedigreeImageService {
	public void addImagePedigree(PedigreeImage image);
	public PedigreeImage getImageById(int id);
	public List<PedigreeImage> getAllImages();
	public PedigreeImage setupPedigreeImage(PedigreeImage image, MultipartFile file);
}
