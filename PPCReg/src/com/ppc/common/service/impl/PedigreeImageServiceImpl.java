package com.ppc.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ppc.common.dao.PedigreeImageDao;
import com.ppc.common.model.PedigreeImage;
import com.ppc.common.service.PedigreeImageService;
import com.ppc.common.util.PropertiesUtil;

@Service("pedigreeImageService")
public class PedigreeImageServiceImpl implements PedigreeImageService {

	@Autowired
	@Qualifier("pedigreeImageDao")
	PedigreeImageDao pedigreeImageDao;
	
	@Override
	@Transactional
	public void addImagePedigree(PedigreeImage image) {
		pedigreeImageDao.addImagePedigree(image);

	}

	@Override
	@Transactional
	public PedigreeImage getImageById(int id) {
		return pedigreeImageDao.getImageById(id);
	}

	@Override
	@Transactional
	public List<PedigreeImage> getAllImages() {		
		return pedigreeImageDao.getAllImages();
	}

	@Override
	public PedigreeImage setupPedigreeImage(PedigreeImage image,
			MultipartFile file) {
		
		image.setFileName(file.getOriginalFilename().replaceAll("\\s+",""));
		image.setContentType(file.getContentType());
		image.setFileSize(file.getSize());
		
		return image;
	}

}
