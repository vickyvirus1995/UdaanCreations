package com.vickyvirus.udaan.controller;

import org.apache.jasper.tagplugins.jstl.core.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("searchProduct")
	public ModelAndView getSearchProducts(@RequestParam("searchKeyword") String searchKeyword)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("PRODUCTS",productApplication.getSearchProducts(searchKeyword));
		modelAndView.setViewName("products");
		return modelAndView;
	}
	
	@RequestMapping("sortProductsByRecords")
	public ModelAndView sortRecords(@RequestParam("numberOfRecord") String numberOfRecords)
	{
		ModelAndView modelAndView = new ModelAndView();
	
		modelAndView.addObject("SELECTEDRECORDS",numberOfRecords);
		modelAndView.addObject("PRODUCTS",productApplication.getAllProducts(numberOfRecords));
		modelAndView.setViewName("products");
		return modelAndView;
	}
	
	@RequestMapping("sortProductsByType")
	public ModelAndView sort(@RequestParam("sortType") String sortType)
	{
		ModelAndView modelAndView = new ModelAndView();
	
		modelAndView.addObject("SORTTYPE",sortType);
		modelAndView.addObject("PRODUCTS",productApplication.sortByType(sortType));
		modelAndView.setViewName("products");
		return modelAndView;
	}
	
	@RequestMapping("products")
	public ModelAndView getProduct()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("SELECTEDRECORDS","9");
		modelAndView.addObject("SORTTYPE","Default Sorting");
		modelAndView.addObject("PRODUCTS",productApplication.getAllProducts("9"));
		modelAndView.setViewName("products");
		return modelAndView;
	}
	

	@RequestMapping("sortSalesProductsByRecords")
	public ModelAndView sortSalesRecords(@RequestParam("numberOfRecord") String numberOfRecords)
	{
		ModelAndView modelAndView = new ModelAndView();
	
		modelAndView.addObject("SELECTEDRECORDS",numberOfRecords);
		modelAndView.addObject("SALESPRODUCTS",productApplication.getAllSalesProducts(numberOfRecords));
		modelAndView.setViewName("sale");
		return modelAndView;
	}
	
	@RequestMapping("sortSalesProductsByType")
	public ModelAndView sortProductsByType(@RequestParam("sortType") String sortType)
	{
		ModelAndView modelAndView = new ModelAndView();
	
		modelAndView.addObject("SORTTYPE",sortType);
		modelAndView.addObject("SALESPRODUCTS",productApplication.sortSalesProductsByType(sortType));
		modelAndView.setViewName("sale");
		return modelAndView;
	}
	
	@RequestMapping("sale")
	public ModelAndView getSale()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("SELECTEDRECORDS","9");
		modelAndView.addObject("SORTTYPE","Default Sorting");
		modelAndView.addObject("SALESPRODUCTS",productApplication.getAllSalesProducts("9"));
		modelAndView.setViewName("sale");
		return modelAndView;
	}
	

	

	
	
}
