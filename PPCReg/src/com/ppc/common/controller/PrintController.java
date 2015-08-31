package com.ppc.common.controller;

import javax.validation.Valid;

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
import com.ppc.common.model.Pedigree;
import com.ppc.common.model.Print;
import com.ppc.common.service.AdvertisementService;
import com.ppc.common.service.PedigreeService;
import com.ppc.common.service.PrintService;
import com.ppc.common.service.UserService;
import com.ppc.common.util.AuthenticationUtil;
@Controller
@RequestMapping("/print")
public class PrintController extends InitBinderController{
	@Autowired
	@Qualifier("printService")
	PrintService printService;
	
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
	@Qualifier("advertisementService")
	AdvertisementService advertisementService;
	
	@Autowired
	@Qualifier("pedigreeService")
	PedigreeService pedigreeService;
	
	@RequestMapping("/add")
	public String addPrint(ModelMap model, @ModelAttribute("print") Print print){
		 
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("dog", pedigreeService.getAllPedigrees());
		model.addAttribute("loginheader", AuthenticationUtil.getAuthenticationDetails().getName());
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		model.addAttribute("displayAds", ads);

		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		model.addAttribute("adsFooter", ads2);
		
		Advertisement ads3 = new Advertisement();
		ads3 = advertisementService.getAdvertisement("Side", "Subpage");
		model.addAttribute("adSide", ads3);

		
		return "prints/addPrint";
	}
	
	@RequestMapping(value = "/success",method=RequestMethod.POST)
	public String printSuccess(@ModelAttribute("print") Print print, ModelMap model){
		long pedigreeId = print.getPedigree().getId();
		long userId = print.getUser().getId();
		model.addAttribute("print", print);
		model.addAttribute("p", pedigreeService.getPedigreeById(pedigreeId));
		model.addAttribute("user", userService.getUserById(userId)); // for new owner
		model.addAttribute("sireList", pedigreeService.getAllSire());
		model.addAttribute("damList", pedigreeService.getAllDam());
		printService.addPrint(print);
		return "prints/certificate";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String getPrint(@PathVariable(value = "id") int id,  ModelMap model) {
		Print print = new Print();
		model.put("print", print);
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("dogs", pedigreeService.getAllPedigrees());
		model.addAttribute("p", printService.getPrintById(id));
		model.addAttribute("loginheader", AuthenticationUtil.getAuthenticationDetails().getName());
		
		
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		model.addAttribute("displayAds", ads);

		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		model.addAttribute("adsFooter", ads2);
		
		Advertisement ads3 = new Advertisement();
		ads3 = advertisementService.getAdvertisement("Side", "Subpage");
		model.addAttribute("adSide", ads3);

		
		return "prints/editPrint";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String updatePrint( @ModelAttribute("print") @Valid  Print print,
			ModelMap model ) {
		 printService.updatePrint(print);
		return "redirect:/print/list";
	}
	
	@RequestMapping(value="/list")
	public String Print(Model map){
		map.addAttribute("prints",printService.getAllPrints());
		map.addAttribute("loginheader", AuthenticationUtil.getAuthenticationDetails().getName());
		
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		map.addAttribute("displayAds", ads);

		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		map.addAttribute("adsFooter", ads2);

		
		
		return "prints/printList";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deletePrint(@PathVariable(value = "id") int id, ModelMap model){
		Print print = new Print(id);
		printService.deletePrint(print);
		return "redirect:/print/list";
	}
	
	/*
	@RequestMapping(value="/certficate/{id}")
	public String certificatePrint(@PathVariable(value = "id") int id, ModelMap model){
		return "prints/certificate";
	}
	*/
	
	@RequestMapping(value = "ads/{id}")
	public String showAds(@PathVariable(value = "id") int id,ModelMap model,@ModelAttribute("advertisement") Advertisement advertisement){
		advertisement = advertisementService.getAdvertisementById(id);
		
		advertisementService.updateAdsCounter(advertisement); 
		model.addAttribute("ads", advertisement.getUrl());
		return "redirect:" + advertisement.getUrl();
	} 
	
	
}
