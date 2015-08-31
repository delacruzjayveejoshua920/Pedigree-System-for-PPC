package com.ppc.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.ppc.common.model.PedigreeImage;
import com.ppc.common.model.User;
import com.ppc.common.service.AdvertisementService;
import com.ppc.common.service.FileService;
import com.ppc.common.service.PedigreeImageService;
import com.ppc.common.service.UserService;
import com.ppc.common.util.AuthenticationUtil;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
	@Qualifier("fileService")
	FileService fileService;
	
	@Autowired
	@Qualifier("pedigreeImageService")
	PedigreeImageService pedigreeImageService;
	
	@Autowired
	@Qualifier("advertisementService")
	AdvertisementService advertisementService;
	
	
	private static final Logger logger = Logger.getLogger(MainController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model map){
		return "login";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(Model map){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    //String name = auth.getName(); //get logged in username
	    //String s = auth.getName();
		Advertisement ads = new Advertisement();
		ads = advertisementService.getAdvertisement("Header", "Main");
		map.addAttribute("displayAds", ads);
		
		Advertisement ads2 = new Advertisement();
		ads2 = advertisementService.getAdvertisement("Footer", "Main");
		map.addAttribute("adsFooter", ads2);
		
		ads = advertisementService.getAdvertisement("Side", "Main");
		map.addAttribute("adSide", ads);
		return "login";
	}
	
	@RequestMapping(value = "ads/{id}")
	public String showAds(@PathVariable(value = "id") int id,ModelMap model,@ModelAttribute("advertisement") Advertisement advertisement){
		advertisement = advertisementService.getAdvertisementById(id);
		
		advertisementService.updateAdsCounter(advertisement); 
		model.addAttribute("ads", advertisement.getUrl());
		return "advertisements/showads";
	} 
	
	@RequestMapping(value = "/addUser", method=RequestMethod.GET)
	public String addUser(Model map){
		logger.info("inserting user");
		
		User user = new User();
		user.setEmail("zaldua.lance@gmail.com");
		user.setFirstName("Lance");
		user.setLastName("Zaldua");
		user.setMiddleName("Cumpas");
		user.setPassword("password");
		user.setUsername("lzaldua");
		
		userService.addUser(user);
	
		return "users/addUser";
	}
	
	@RequestMapping(value="/user/{id}")
	public String getUser(@PathVariable(value = "id")int id,Model map){
		logger.info("getting user");
		map.addAttribute("user", userService.getUserById(id));
		
		return "users/getUser";
	}
	
	@RequestMapping(value="/users")
	public String getUsers(Model map){
		logger.info("getting users");
		map.addAttribute("users",userService.getAllUsers());
		logger.info(AuthenticationUtil.getAuthenticationDetails().getName());
		return "users/getUsers";
	}
	
	@RequestMapping(value="/upload")
	public String upload(Model map){
		PedigreeImage pedigreeImage = new PedigreeImage();
		map.addAttribute("pedigreeImage",pedigreeImage);
		List<PedigreeImage> list = pedigreeImageService.getAllImages();
		map.addAttribute("listPedigreeImage",list);
		
		return "uploads/fileUpload";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(@Valid PedigreeImage pedigreeImage,BindingResult bindingResult,
			@RequestParam(value="file") MultipartFile file, Model map, HttpServletRequest request, RedirectAttributes attr){
		
		if(bindingResult.hasErrors() || file.isEmpty()){
			return "uploads/fileUpload";
		}
		
		pedigreeImage = pedigreeImageService.setupPedigreeImage(pedigreeImage, file);
		pedigreeImageService.addImagePedigree(pedigreeImage);	
		if(fileService.uploadFile(file, pedigreeImage)){
			return "redirect:/upload";
		}
		
		
		return "redirect:/upload";
		
	}
}
