package com.ppc.common.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ppc.common.model.Advertisement;
import com.ppc.common.model.User;
import com.ppc.common.service.AdvertisementService;
import com.ppc.common.service.UserService;
import com.ppc.common.util.AuthenticationUtil;

@Controller
@RequestMapping("/user")
public class UserController extends InitBinderController {
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
	@Qualifier("advertisementService")
	AdvertisementService advertisementService;
	
	private static final Logger logger = Logger.getLogger(AdvertisementController.class);
	
	
	@RequestMapping("/add")
	public String addUser(ModelMap model) {
		User user = new User();
		model.put("user", user);
		model.addAttribute("loginheader", AuthenticationUtil.getAuthenticationDetails().getName());
		
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		model.addAttribute("displayAds", ads);

		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		model.addAttribute("adsFooter", ads2);

		ads = advertisementService.getAdvertisement("Side", "Subpage");
		model.addAttribute("adSide", ads);
		return "users/addUser";
	}

	@RequestMapping(value = "add/success", method = RequestMethod.POST)
	public String advertisementSuccess(@ModelAttribute("user") User user,ModelMap model) {
		userService.addUser(user);
		return "redirect:/user/list";
	}
	
	
	@RequestMapping(value = "edit/{id}")
	public String getUser(@PathVariable(value = "id") int id,  ModelMap model) {
		User users = new User();
		model.put("users", users);
		model.addAttribute("user", userService.getUserById(id));
		model.addAttribute("loginheader", AuthenticationUtil.getAuthenticationDetails().getName());
		
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		model.addAttribute("displayAds", ads);

		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		model.addAttribute("adsFooter", ads2);

		ads = advertisementService.getAdvertisement("Side", "Subpage");
		model.addAttribute("adSide", ads);
		
		return "users/editUser";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String updateAdvertisement( @ModelAttribute("user") @Valid User user,
			ModelMap model ) {
		logger.info("update user");
		userService.updateUser(user);
		model.addAttribute("loginheader", AuthenticationUtil.getAuthenticationDetails().getName());
		return "redirect:/user/list";
	}
	
	@RequestMapping(value="/list")
	public String UserList(Model map){
		map.addAttribute("users",userService.getAllUsers());
		map.addAttribute("loginheader", AuthenticationUtil.getAuthenticationDetails().getName());
		
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		map.addAttribute("displayAds", ads);
		
		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		map.addAttribute("adsFooter", ads2);
		
		ads = advertisementService.getAdvertisement("Side", "Subpage");
		map.addAttribute("adSide", ads);
		return "users/userList";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteUser(@PathVariable(value = "id") int id, ModelMap model){
		User user = new User(id);
		userService.deleteUser(user);
		return "redirect:/user/list";
	}
	
	@RequestMapping(value = "ads/{id}")
	public String showAds(@PathVariable(value = "id") int id,ModelMap model,@ModelAttribute("advertisement") Advertisement advertisement){
		advertisement = advertisementService.getAdvertisementById(id);
		
		advertisementService.updateAdsCounter(advertisement); 
		model.addAttribute("ads", advertisement.getUrl());
		return "redirect:" + advertisement.getUrl();
	} 
}
