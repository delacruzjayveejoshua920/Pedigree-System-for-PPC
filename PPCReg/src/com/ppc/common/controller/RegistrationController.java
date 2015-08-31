package com.ppc.common.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ppc.common.model.Advertisement;
import com.ppc.common.model.User;
import com.ppc.common.service.AdvertisementService;
import com.ppc.common.service.UserService;

@Controller
public class RegistrationController extends InitBinderController{
	
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
	@Qualifier("advertisementService")
	AdvertisementService advertisementService;
	
	//private static final Logger logger = Logger.getLogger(AccountController.class);
	
	@RequestMapping("/register")
	public String register(ModelMap model){
		User register = new User();
		model.put("register", register);
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Main");
		model.addAttribute("displayAds", ads);
		
		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Main");
		model.addAttribute("adsFooter", ads2);
		
		Advertisement ads3 = new Advertisement();
		ads3 = advertisementService.getAdvertisement("Side", "Main");
		model.addAttribute("adSide", ads3);
		
		return "register";
	}
	
	@RequestMapping(value = "/registrationProcess",method=RequestMethod.POST)
	public String registrationProcess(@ModelAttribute("register") User register, ModelMap model){
		//logger.info("inserting user");
		register.setIsActive(true);
		register.setRole("User");
		userService.addUser(register);
		
		return "redirect: /PPCReg/login";
	}
	
	@RequestMapping(value = "ads/{id}")
	public String showAds(@PathVariable(value = "id") int id,ModelMap model,@ModelAttribute("advertisement") Advertisement advertisement){
		advertisement = advertisementService.getAdvertisementById(id);
		
		advertisementService.updateAdsCounter(advertisement); 
		model.addAttribute("ads", advertisement.getUrl());
		return "advertisements/showads";
	} 
	
	
}
