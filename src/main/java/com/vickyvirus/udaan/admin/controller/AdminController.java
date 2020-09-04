package com.vickyvirus.udaan.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.vickyvirus.udaan.admin.application.AdminProductApplication;

@Controller
public class AdminController {

	@Autowired
	AdminProductApplication adminProductApplication;
	
	
	@RequestMapping("admin")
	public RedirectView getAdminLogin()
	{
		return new RedirectView("admin/login.jsp");
	}
	
	@RequestMapping("admin/verifyLogin")
	public ModelAndView verifyLogin()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("USER","nilesh Shinde");
		mv.setViewName("admin/home");
		return mv;
	}
	
	
	@RequestMapping("adminAddProduct")
	public String getAddProduct()
	{
		return "adminAddProduct";
	}
	
	@RequestMapping(value= "addProduct",method = RequestMethod.POST )
	public RedirectView addProduct(@RequestParam("name")String name,
			@RequestParam("quantity")String quantity,@RequestParam("price")String price,
			@RequestParam("image") MultipartFile image,HttpServletRequest request)
	{
		
		adminProductApplication.addProduct(name, quantity, price, image);
		String contextPath = request.getContextPath();
	    return new RedirectView(contextPath + "/adminAddProduct");
		
	}
	
	
	
	@RequestMapping("admin/adminAllProducts")
	public ModelAndView getAdminAllProducts()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Products",adminProductApplication.getAllProducts());
		modelAndView.setViewName("admin/adminAllProducts");
		return modelAndView;
		
	}
	
	@RequestMapping("/adminEditProducts")
	public ModelAndView getAdminEditProducts()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("product",adminProductApplication.getAllProducts());
		modelAndView.setViewName("adminEditProduct");
		return modelAndView;
		
	}
	
	@RequestMapping("/editProductDetails")
	public ModelAndView getAdminEditProductsDetails(@RequestParam("product_id") Integer product_id)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("editProduct",adminProductApplication.getProductById(product_id));
		modelAndView.addObject("product",adminProductApplication.getAllProductsExceptSelected(product_id));
		modelAndView.setViewName("adminEditProduct");
		return modelAndView;
		
	}

}
