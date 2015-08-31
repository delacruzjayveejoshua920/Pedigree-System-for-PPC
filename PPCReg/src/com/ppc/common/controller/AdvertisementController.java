package com.ppc.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.ppc.common.model.User;
import com.ppc.common.service.AdvertisementService;
import com.ppc.common.service.FileService;
import com.ppc.common.service.PedigreeImageService;
import com.ppc.common.service.UserService;
import com.ppc.common.util.AuthenticationUtil;

@Controller
@RequestMapping("/advertisement")
public class AdvertisementController extends InitBinderController {

	@Autowired
	@Qualifier("advertisementService")
	AdvertisementService advertisementService;

	@Autowired
	@Qualifier("userService")
	UserService userService;

	@Autowired
	@Qualifier("pedigreeImageService")
	PedigreeImageService pedigreeImageService;

	@Autowired
	@Qualifier("fileService")
	FileService fileService;

	private static final Logger logger = Logger
			.getLogger(AdvertisementController.class);

	@RequestMapping("/add")
	public String addAds(ModelMap model) {
		Advertisement advertisement = new Advertisement();

		model.put("advertisement", advertisement);
		model.addAttribute("users", userService.getAllUsers());
		// model.addAttribute("displayAds",
		// advertisementService.getAdvertisementById(27));
		model.addAttribute("loginheader", AuthenticationUtil
				.getAuthenticationDetails().getName());
		
		
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		model.addAttribute("displayAds", ads);

		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		model.addAttribute("adsFooter", ads2);

		Advertisement ads3 = new Advertisement();
		ads3 = advertisementService.getAdvertisement("Side", "Subpage");
		model.addAttribute("adSide", ads3);

		return "advertisements/addAdvertisement";
	}

	@RequestMapping(value = "add/success", method = RequestMethod.POST)
	public String advertisementSuccess(@Valid PedigreeImage pedigreeImage,
			BindingResult bindingResult,
			@RequestParam(value = "file") MultipartFile file,
			HttpServletRequest request, RedirectAttributes attr,
			@ModelAttribute("advertisement") Advertisement advertisement,
			ModelMap model) {

		pedigreeImage = pedigreeImageService.setupPedigreeImage(pedigreeImage,
				file);
		pedigreeImageService.addImagePedigree(pedigreeImage);
		fileService.uploadFile(file, pedigreeImage);
		advertisement.setPedigreeimage(pedigreeImage);
		User user = new User();
		user = userService.getUserByUsername(AuthenticationUtil.getAuthenticationDetails().getName());
		
		advertisement.setUser(user);
		advertisementService.addAdvertisement(advertisement);
		// advertisementService.addAdvertisement(advertisement);
		return "redirect:/advertisement/list";
	}
	
	

	@RequestMapping(value = "/edit/{id}")
	public String getAdvertisement(@PathVariable(value = "id") int id,
			ModelMap model) {
		Advertisement advertisement = new Advertisement();

		model.put("advertisement", advertisement);
		model.addAttribute("ads", advertisementService.getAdvertisementById(id));
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("loginheader", AuthenticationUtil
				.getAuthenticationDetails().getName());
		
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		model.addAttribute("displayAds", ads);

		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		model.addAttribute("adsFooter", ads2);

		Advertisement ads3 = new Advertisement();
		ads3 = advertisementService.getAdvertisement("Side", "Subpage");
		model.addAttribute("adSide", ads3);
		
		
		return "advertisements/editAdvertisement";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String updateAdvertisement(
			@Valid PedigreeImage pedigreeImage,
			BindingResult bindingResult,
			@RequestParam(value = "file") MultipartFile file,
			HttpServletRequest request,
			RedirectAttributes attr,
			@ModelAttribute("advertisement") @Valid Advertisement advertisement,
			ModelMap model) {
		logger.info("update user");
		pedigreeImage = pedigreeImageService.setupPedigreeImage(pedigreeImage,
				file);
		User user = new User();
		pedigreeImageService.addImagePedigree(pedigreeImage);
		fileService.uploadFile(file, pedigreeImage);
		advertisement.setPedigreeimage(pedigreeImage);
		//user.setAdvertisement(advertisement);
		advertisement.setUser(user);
		advertisementService.updateAdvertisement(advertisement);
	    
		
		return "redirect:/advertisement/list";
	}

	@RequestMapping(value = "/edit/image/{id}")
	public String currentViewImage(@PathVariable(value = "id") int id,
			ModelMap model) {
		model.addAttribute("images", pedigreeImageService.getImageById(id));
		return "images/viewImage";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteAdvertisement(@PathVariable(value = "id") int id,
			ModelMap model) {
		Advertisement ads = new Advertisement(id);
		advertisementService.deleteAdvertisement(ads);
		return "redirect:/advertisement/list";
	}

	@RequestMapping(value = "/list")
	public String advertisementList(Model map, User user) {
		logger.info("getting advertisement list");
		user = userService.getUserByUsername(AuthenticationUtil.getAuthenticationDetails().getName());
		map.addAttribute("advertisements",
				advertisementService.getAllAdvertisements());
		map.addAttribute("loginheader", AuthenticationUtil
				.getAuthenticationDetails().getName());
		
		long id = user.getId();
		List<Advertisement> alist = advertisementService.getAllAdvertisementsbyId(id);
		map.addAttribute("AdsUser", alist);
 
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Subpage");
		map.addAttribute("displayAds", ads);

		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Subpage");
		map.addAttribute("adsFooter", ads2);

		
		return "advertisements/advertisementList";
	}

	@RequestMapping(value = "/image/{id}")
	public String viewImage(@PathVariable(value = "id") int id, ModelMap model) {
		model.addAttribute("images", pedigreeImageService.getImageById(id));
		return "images/viewImage";
	}
	
	@RequestMapping(value = "ads/{id}")
	public String showAds(@PathVariable(value = "id") int id, ModelMap model,
			@ModelAttribute("advertisement") Advertisement advertisement) {
		advertisement = advertisementService.getAdvertisementById(id);
		advertisementService.updateAdsCounter(advertisement);
		return "redirect:" + advertisement.getUrl();
	}
	

}
