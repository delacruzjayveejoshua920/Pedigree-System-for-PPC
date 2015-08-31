package com.ppc.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ppc.common.model.Advertisement;
import com.ppc.common.model.Pedigree;
import com.ppc.common.model.PedigreeImage;
import com.ppc.common.model.Print;
import com.ppc.common.model.User;
import com.ppc.common.service.AdvertisementService;
import com.ppc.common.service.FileService;
import com.ppc.common.service.PedigreeImageService;
import com.ppc.common.service.PedigreeService;
import com.ppc.common.service.PrintService;
import com.ppc.common.service.UserService;
import com.ppc.common.util.AuthenticationUtil;

@Controller
@RequestMapping("/pedigree")
public class PedigreeController extends InitBinderController {

	@Autowired
	@Qualifier("pedigreeService")
	PedigreeService pedigreeService;

	@Autowired
	@Qualifier("pedigreeImageService")
	PedigreeImageService pedigreeImageService;

	@Autowired
	@Qualifier("userService")
	UserService userService;

	@Autowired
	@Qualifier("fileService")
	FileService fileService;
	
	@Autowired
	@Qualifier("advertisementService")
	AdvertisementService advertisementService;
	
	@Autowired
	@Qualifier("printService")
	PrintService printService;

	@RequestMapping("/add")
	public String addPedigree(ModelMap model) {
		Pedigree pedigree = new Pedigree();
		model.addAttribute("loginheader", AuthenticationUtil.getAuthenticationDetails().getName());
		model.put("pedigree", pedigree);
		model.addAttribute("sireList", pedigreeService.getAllSire());
		model.addAttribute("damList", pedigreeService.getAllDam());
		
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		model.addAttribute("displayAds", ads);
		
		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		model.addAttribute("adsFooter", ads2);
		
		ads = advertisementService.getAdvertisement("Side", "Subpage");
		model.addAttribute("adSide", ads);
		return "pedigree/addPedigree";
	}

	@RequestMapping(value = "add/success", method = RequestMethod.POST)
	public String pedigreeSuccess(@Valid PedigreeImage pedigreeImage,
			BindingResult bindingResult,
			@RequestParam(value = "file") MultipartFile file,
			HttpServletRequest request, RedirectAttributes attr,
			@ModelAttribute("pedigree") Pedigree pedigree, ModelMap model) {

		User user = new User();
		user = userService.getUserByUsername(AuthenticationUtil
				.getAuthenticationDetails().getName());
		pedigreeImage = pedigreeImageService.setupPedigreeImage(pedigreeImage,
				file);
		pedigreeImageService.addImagePedigree(pedigreeImage);
		fileService.uploadFile(file, pedigreeImage);
		pedigree.setPedigreeimage(pedigreeImage);
		//if(user.getRole() == "User"){
		//pedigree.setUser(user);
		//}
		
		if(user.getRole() == "User"){
			pedigree.setIsApproved(false);
		}
		pedigree.setUser(user);
		
		pedigreeService.addPedigree(pedigree);
		return "redirect:/pedigree/list";
	}

	@RequestMapping(value = "/edit/{id}")
	public String getPedigree(@PathVariable(value = "id") int id, ModelMap model) {
		Pedigree pedigree = new Pedigree();
		model.put("pedigree", pedigree);
		model.addAttribute("p", pedigreeService.getPedigreeById(id));
		model.addAttribute("sireList", pedigreeService.getAllSire());
		model.addAttribute("damList", pedigreeService.getAllDam());
		model.addAttribute("loginheader", AuthenticationUtil.getAuthenticationDetails().getName());
		
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		model.addAttribute("displayAds", ads);
		
		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		model.addAttribute("adsFooter", ads2);
		
		ads = advertisementService.getAdvertisement("Side", "Subpage");
		model.addAttribute("adSide", ads);
		return "pedigree/editPedigree";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String updatePedigree(@Valid PedigreeImage pedigreeImage,
			BindingResult bindingResult,
			@RequestParam(value = "file") MultipartFile file,
			HttpServletRequest request, RedirectAttributes attr,
			@ModelAttribute("pedigree") @Valid Pedigree pedigree, ModelMap model) {

		pedigreeImage = pedigreeImageService.setupPedigreeImage(pedigreeImage,
				file);
		pedigreeImageService.addImagePedigree(pedigreeImage);
		fileService.uploadFile(file, pedigreeImage);
		//pedigree.setUser(user);
		pedigree.setPedigreeimage(pedigreeImage);
		pedigreeService.updatePedigree(pedigree);
		return "redirect:/pedigree/list";
	}

	@RequestMapping(value = "/list")
	public String PedigreeList(Model map, User user, Pedigree pedigree) {
		user = userService.getUserByUsername(AuthenticationUtil.getAuthenticationDetails().getName());
		List<PedigreeImage> list = pedigreeImageService.getAllImages();
		map.addAttribute("loginheader", AuthenticationUtil.getAuthenticationDetails().getName());
		map.addAttribute("pedigrees", pedigreeService.getAllPedigreeById(pedigree));
		//map.addAttribute("pedigrees", pedigreeService.getAllPedigrees());
		
		
		long id = user.getId();
		List<Pedigree> plist =  pedigreeService.getAllPedigreeById(pedigree);
		map.addAttribute("pedigreesByUser", plist);
		//map.addAttribute("pedigreesByUser", plist);
		map.addAttribute("pedigreeImage", list);
		
		map.addAttribute("sireList", pedigreeService.getAllSire());
		map.addAttribute("damList", pedigreeService.getAllDam());
		
		
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		map.addAttribute("displayAds", ads);
		
		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		map.addAttribute("adsFooter", ads2);
		
		Advertisement ads3 = new Advertisement();
		ads3 = advertisementService.getAdvertisement("Side", "Subpage");
		map.addAttribute("adSide", ads3);
		return "pedigree/pedigreeList";
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchPedigree(Model map, User user,@ModelAttribute("pedigree") @Valid Pedigree pedigree) {
		String query = pedigree.getName();
		List<Pedigree> resultList =  pedigreeService.getAllPedigreeByKeyword(query);
		map.addAttribute("searchResult", resultList);
		return "pedigree/searchPedigree";
	}
	
	
	@RequestMapping(value = "/list/disapprove")
	public String unapprovedPedigreeList(ModelMap map, Pedigree pedigree, User user){
		map.addAttribute("loginheader", AuthenticationUtil.getAuthenticationDetails().getName());
		map.addAttribute("pedigreeDisapprove", pedigreeService.getAllPedigreeDisapprove());
		
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		map.addAttribute("displayAds", ads);
		
		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		map.addAttribute("adsFooter", ads2);
		
		Advertisement ads3 = new Advertisement();
		ads3 = advertisementService.getAdvertisement("Side", "Subpage");
		map.addAttribute("adSide", ads3);
		
		return "pedigree/unapprovedPedigreeList";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deletePedigree(@PathVariable(value = "id") int id,
			ModelMap model) {
		Pedigree pedigree = new Pedigree(id);
		pedigreeService.deletePedigree(pedigree);
		return "redirect:/pedigree/list";
	}

	@RequestMapping(value = "/image/{id}")
	public String viewImage(@PathVariable(value = "id") int id, ModelMap model) {
		model.addAttribute("images", pedigreeImageService.getImageById(id));
		
		return "images/viewImage";
	}

	@RequestMapping(value = "/certificate", method = RequestMethod.POST)
	public String certificatePrint(ModelMap model, @ModelAttribute("print") @Valid Print print) {
		
		model.addAttribute("p", pedigreeService.getPedigreeById(print.getPedigree().getId()));
		model.addAttribute("sireList", pedigreeService.getAllSire());
		model.addAttribute("damList", pedigreeService.getAllDam());
//		model.addAttribute("users", userService.getAllUsers());
//		model.addAttribute("dog", pedigreeService.getAllPedigrees());
		return "prints/certificate";
	}
	
	@RequestMapping(value = "/printform/{id}")
	public String printForm(@PathVariable(value = "id") int id, ModelMap model){
		Print print = new Print();
		model.put("print", print);
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("dog", pedigreeService.getAllPedigrees());
		model.addAttribute("user", userService.getUserById(id));
		model.addAttribute("loginheader", AuthenticationUtil.getAuthenticationDetails().getName());
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		model.addAttribute("displayAds", ads);

		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		model.addAttribute("adsFooter", ads2);

		
		return "prints/addPrint";
	}
	
	
	@RequestMapping(value = "printform/success",method=RequestMethod.POST)
	public String printSuccess(@ModelAttribute("print") Print print, ModelMap model){
		printService.addPrint(print);
		return "redirect:/print/list";
	}
	
	
	@RequestMapping(value = "ads/{id}")
	public String showAds(@PathVariable(value = "id") int id,ModelMap model,@ModelAttribute("advertisement") Advertisement advertisement){
		advertisement = advertisementService.getAdvertisementById(id);
		
		advertisementService.updateAdsCounter(advertisement); 
		model.addAttribute("ads", advertisement.getUrl());
		return "redirect:" + advertisement.getUrl();
	} 
}
