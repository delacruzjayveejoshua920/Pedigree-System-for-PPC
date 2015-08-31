package com.ppc.common.service;

import org.springframework.web.multipart.MultipartFile;

import com.ppc.common.model.PedigreeImage;

public interface FileService {

	public boolean uploadFile(MultipartFile file,PedigreeImage imagePedigree);
}
