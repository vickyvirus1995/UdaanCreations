package com.vickyvirus.udaan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vickyvirus.udaan.application.ProductApplication;

@Controller
public class HomeController {
	
	@Autowired
	private ProductApplication productApplication;
	
	@RequestMapping("")
	public ModelAndView getHome()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("PRODUCTS",productApplication.getLatestProducts());
		modelAndView.setViewName("index");
		return modelAndView;
		
	}

	@RequestMapping("home")
	public String getHomePage()
	{
		return "index";
	}
	
	
	
}
