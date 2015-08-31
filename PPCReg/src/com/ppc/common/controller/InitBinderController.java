 package com.ppc.common.controller;
 
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class InitBinderController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@InitBinder
    public void initBinderDouble(WebDataBinder binder) {
		DecimalFormat format = new DecimalFormat("0,00");
		binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, format, true));
    }
	
	
	/*
	@InitBinder
	public void initBinder(HttpServletRequest request, 
			  ServletRequestDataBinder binder) throws Exception
			{
			  // bind empty strings as null
			  binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
			}
	*/
}