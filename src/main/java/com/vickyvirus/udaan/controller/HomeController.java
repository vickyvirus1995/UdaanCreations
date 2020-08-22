package com.vickyvirus.udaan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.vickyvirus.udaan.application.ProductApplication;

@Controller
public class HomeController {
	
	@Autowired
	private ProductApplication productApplication;
	
	@RequestMapping("")
	public String getHome()
	{
		return "index";
	}

	@RequestMapping("home")
	public String getHomePage()
	{
		return "index";
	}
	
	
	@RequestMapping("add_product")
	public String getAddProduct()
	{
		return "add_product";
	}
	
	@RequestMapping(value= "addProduct",method = RequestMethod.POST )
	public RedirectView addProduct(@RequestParam("name")String name,
			@RequestParam("quantity")String quantity,@RequestParam("price")String price,
			@RequestParam("image") MultipartFile image,HttpServletRequest request)
	{
		
		productApplication.addProduct(name, quantity, price, image);
		String contextPath = request.getContextPath();
	    return new RedirectView(contextPath + "/add_product");
		
	}
	
	@RequestMapping("/allProducts")
	public ModelAndView getAllProducts()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Products",productApplication.getAllProducts());
		modelAndView.setViewName("all_product");
		return modelAndView;
		
	}
	

}
