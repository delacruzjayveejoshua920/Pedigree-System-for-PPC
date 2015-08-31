package com.ppc.common.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppc.common.dao.AdvertisementDao;
import com.ppc.common.dao.PedigreeDao;
import com.ppc.common.model.Advertisement;
import com.ppc.common.model.Pedigree;
import com.ppc.common.model.PedigreeImage;
import com.ppc.common.model.User;
import com.ppc.common.service.AdvertisementService;


@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService{
	
	@Autowired
	@Qualifier("advertisementDao")
	private AdvertisementDao advertisementDao;
	
	@Override
	@Transactional
	public void addAdvertisement(Advertisement advertisement){
		advertisementDao.addAdvertisement(advertisement);
	}
	
	@Override
	@Transactional
	public void updateAdvertisement(Advertisement advertisement) {
		advertisementDao.updateAdvertisement(advertisement);
	}
	
	@Override
	@Transactional
	public void deleteAdvertisement(Advertisement advertisement) {
		advertisementDao.deleteAdvertisement(advertisement);
	}
	
	@Override
	@Transactional
	public void updateAdsCounter(Advertisement advertisement){
		advertisementDao.updateAdsCounter(advertisement);
	}
	
	@Override
	@Transactional
	public Advertisement getAdvertisementById(int id){
		Advertisement advertisement = advertisementDao.getAdvertisementById(id);
		return advertisement;
	}
	
	@Override
	@Transactional
	public List<Advertisement> getAllAdvertisements() {
		List<Advertisement> advertisement = advertisementDao.getAllAdvertisements();
		return advertisement;
	}
	
	@Override
	@Transactional
	public List<Advertisement> getAllAdvertisementsbyId(long id){
		List<Advertisement> advertisement = advertisementDao.getAllAdvertisementsbyId(id);
		return advertisement;
	}
	
	@Override
	@Transactional
	public Advertisement getAdvertisement(String location, String type){
		Advertisement advertisement = advertisementDao.getAdvertisement(location, type);
		return advertisement;
	}
	
	
}
