package com.ppc.common.dao;

import java.util.List;

import com.ppc.common.model.Advertisement;
import com.ppc.common.model.PedigreeImage;

public interface AdvertisementDao {
	public void addAdvertisement(Advertisement advertisement);	
	public void updateAdvertisement(Advertisement advertisement);
	public void deleteAdvertisement(Advertisement advertisement);
	public void updateAdsCounter(Advertisement advertisement);
	public Advertisement getAdvertisementById(int id);
	public List<Advertisement> getAllAdvertisements();
	public List<Advertisement> getAllAdvertisementsbyId(long id);
	public Advertisement getAdvertisement(String location, String type);
	
}
