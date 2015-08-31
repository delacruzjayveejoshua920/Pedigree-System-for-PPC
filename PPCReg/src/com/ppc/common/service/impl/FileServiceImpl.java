package com.ppc.common.service.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ppc.common.model.PedigreeImage;
import com.ppc.common.service.FileService;
import com.ppc.common.util.PropertiesUtil;

@Service("fileService")
public class FileServiceImpl implements FileService {

	private static final Logger logger = Logger.getLogger(FileService.class);

	@Override
	public boolean uploadFile(MultipartFile file, PedigreeImage pedigreeImage) {
		String fileDir = PropertiesUtil.getProperty("file.dir");
		if (!pedigreeImage.getContentType().contains("jpg")
				|| !pedigreeImage.getContentType().contains("png")) {//check if file is an image
		 
			File f = new File(fileDir + pedigreeImage.getFileName());
			try {
				FileUtils.writeByteArrayToFile(f, file.getBytes());
			} catch (IOException e) {
				logger.error(e.getLocalizedMessage());
				return false;
			}
		}else{	return false;
		}
		return true;
	}

}
