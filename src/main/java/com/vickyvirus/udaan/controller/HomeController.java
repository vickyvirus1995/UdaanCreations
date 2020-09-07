package com.vickyvirus.udaan.controller;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.vickyvirus.udaan.application.ProductApplication;

@Controller
public class HomeController {
	
	@Autowired
	private ProductApplication productApplication;
	
	@RequestMapping("")
	public RedirectView getHome()
	{
		return new RedirectView("home");
		
	}

	@RequestMapping("home")
	public ModelAndView getHomePage()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("PRODUCTS",productApplication.getLatestProducts());
		modelAndView.addObject("SALESPRODUCTS",productApplication.getLatestSalesProducts());
		modelAndView.setViewName("index");
		return modelAndView;
		
	}
	
	@RequestMapping("products")
	public ModelAndView getProduct()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("PRODUCTS",productApplication.getAllSalesProducts());
		modelAndView.setViewName("products");
		return modelAndView;
	}
	
	@RequestMapping("sale")
	public ModelAndView getSale()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("SALESPRODUCTS",productApplication.getAllSalesProducts());
		modelAndView.setViewName("sale");
		return modelAndView;
	}
	

	@RequestMapping("sale1")
	public ModelAndView getSale1()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("SALESPRODUCTS",productApplication.getAllSalesProducts());
		modelAndView.setViewName("sale1");
		return modelAndView;
	}

	
	
}
