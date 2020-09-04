package com.vickyvirus.udaan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vickyvirus.udaan.admin.application.AdminProductApplication;

@Controller
public class HomeController {
	
	@Autowired
	private AdminProductApplication adminProductApplication;
	
	@RequestMapping("")
	public ModelAndView getHome()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Products",adminProductApplication.getAllProducts());
		modelAndView.setViewName("index");
		return modelAndView;
		
	}

	@RequestMapping("home")
	public String getHomePage()
	{
		return "index";
	}
	
	
	
}
