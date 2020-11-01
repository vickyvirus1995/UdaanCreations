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

import com.vickyvirus.udaan.admin.application.AdminApplication;
import com.vickyvirus.udaan.admin.application.AdminProductApplication;

@Controller
public class AdminController {

	@Autowired
	AdminProductApplication adminProductApplication;
	@Autowired
	AdminApplication adminApplication;
	
	@RequestMapping("admin")
	public RedirectView getAdminLogin()
	{
		return new RedirectView("admin/login.jsp");
	}
	
	@RequestMapping("admin/verifyLogin")
	public ModelAndView verifyLogin(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		ModelAndView mv = new ModelAndView();
		boolean user = adminApplication.verifyLogin(username,password);
		if(user)
			{
			mv.addObject("USER",username);
			mv.setViewName("admin/home");
			return mv;
			}
		else {
			mv.setViewName("admin/login");
			return mv;
		}
	}
	
	@RequestMapping("admin/addAdmin")
	public ModelAndView addAdmin(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		
		adminApplication.addAdmin(username,password);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/login");
		return mv;
	}
	
	
	@RequestMapping("admin/adminAddProducts")
	public String getAddProduct()
	{
		return "admin/adminAddProduct";
	}
	
	@RequestMapping(value= "admin/addProduct",method = RequestMethod.POST )
	public RedirectView addProduct(@RequestParam("productName")String productName,
			@RequestParam("productQuantity")String productQuantity,@RequestParam("productPrice")Integer productPrice,
			@RequestParam("productImage") MultipartFile productImage,HttpServletRequest request)
	{
		
		adminProductApplication.addProduct(productName, productQuantity, productPrice, productImage);
		String contextPath = request.getContextPath();
	    return new RedirectView(contextPath + "adminAddProducts");
		
	}
	
	
	
	@RequestMapping("admin/adminUpdateProducts")
	public ModelAndView getAdminEditProducts()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("PRODUCTS",adminProductApplication.getAllProducts());
		modelAndView.setViewName("admin/adminUpdateProduct");
		return modelAndView;
		
	}
	
	@RequestMapping("admin/updateProductData")
	public ModelAndView getProductDataForEdit(@RequestParam("productId") Integer productId)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("SELECTEDPRODUCT",adminProductApplication.getProductById(productId.intValue()));
		modelAndView.addObject("PRODUCTS",adminProductApplication.getAllProductsExceptSelected(productId));
		modelAndView.setViewName("admin/adminUpdateProduct");
		return modelAndView;
		
	}
	
	@RequestMapping(value= "admin/updateProduct",method = RequestMethod.POST )
	public RedirectView updateProduct(@RequestParam("productId") Integer productId,@RequestParam("productName")String productName,
			@RequestParam("productQuantity")String productQuantity,@RequestParam("productPrice")Integer productPrice,
			@RequestParam("productImage") MultipartFile productImage,HttpServletRequest request)
	{
		adminProductApplication.updateProduct(productId,productName, productQuantity, productPrice, productImage);
		
		String contextPath = request.getContextPath();
	    return new RedirectView(contextPath + "adminUpdateProducts");
		
	}
	

	@RequestMapping(value= "admin/deleteProduct",method = RequestMethod.POST )
	public RedirectView deleteProduct(@RequestParam("productId") Integer productId,HttpServletRequest request)
	{
		adminProductApplication.deleteProduct(productId);
		
		String contextPath = request.getContextPath();
	    return new RedirectView(contextPath + "adminDeleteProducts");
		
	}
	
	@RequestMapping("admin/adminDeleteProducts")
	public ModelAndView getAdminDeleteProduct()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("PRODUCTS",adminProductApplication.getAllProducts());
		modelAndView.setViewName("admin/adminDeleteProduct");
		return modelAndView;
		
	}
	
	@RequestMapping("admin/deleteProductData")
	public ModelAndView getProductDataForDelete(@RequestParam("productId") Integer productId)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("SELECTEDPRODUCT",adminProductApplication.getProductById(productId.intValue()));
		modelAndView.addObject("PRODUCTS",adminProductApplication.getAllProductsExceptSelected(productId));
		modelAndView.setViewName("admin/adminDeleteProduct");
		return modelAndView;
		
	}
	
	
	@RequestMapping("admin/adminAddSales")
	public ModelAndView getAdminSales()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("PRODUCTS",adminProductApplication.getAllProducts());
		modelAndView.setViewName("admin/adminAddSale");
		return modelAndView;
		
	}
	
	@RequestMapping("admin/addSaleData")
	public ModelAndView getProductDataForSale(@RequestParam("productId") Integer productId)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("SELECTEDPRODUCT",adminProductApplication.getProductById(productId.intValue()));
		modelAndView.addObject("PRODUCTS",adminProductApplication.getAllProductsExceptSelected(productId));
		modelAndView.setViewName("admin/adminAddSale");
		return modelAndView;
		
	}
	

	@RequestMapping(value= "admin/saveSaleData",method = RequestMethod.POST )
	public RedirectView saveSaleData(@RequestParam("productOffer") String productOffer,@RequestParam("productName")String productName,
			@RequestParam("productDiscountedPrice")Integer productDiscountedPrice,
			@RequestParam("productImage") String productImage,@RequestParam("productPrice") Integer productPrice,
			HttpServletRequest request)
	{
		adminProductApplication.saveSaleProduct(productName, productPrice,productDiscountedPrice, productImage,productOffer);
		
		String contextPath = request.getContextPath();
	    return new RedirectView(contextPath + "adminAddSales");
		
	}
	
	
	@RequestMapping("admin/adminUpdateSales")
	public ModelAndView getSalesData()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("PRODUCTS",adminProductApplication.getAllSalesData());
		modelAndView.setViewName("admin/adminUpdateSale");
		return modelAndView;
	}
	
	@RequestMapping("admin/getSelectedSaleData")
	public ModelAndView getSelectedSaleData(@RequestParam("productId") Integer productId)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("SELECTEDSALE",adminProductApplication.getSelectedSale(productId));
		modelAndView.addObject("PRODUCTS",adminProductApplication.getAllSalesDataExceptSelected(productId));
		modelAndView.setViewName("admin/adminUpdateSale");
		return modelAndView;
	
	}
	
	@RequestMapping(value= "admin/updateSaleData",method = RequestMethod.POST )
	public RedirectView updateSaleData(@RequestParam("productId") Integer productId,@RequestParam("productOffer") String productOffer,@RequestParam("productName")String productName,
			@RequestParam("productDiscountedPrice")Integer productDiscountedPrice,
			@RequestParam("productImage") String productImage,@RequestParam("productPrice") Integer productPrice,
			HttpServletRequest request)
	{
		adminProductApplication.updateSaleProduct(productId,productName, productPrice,productDiscountedPrice, productImage,productOffer);
		
		String contextPath = request.getContextPath();
	    return new RedirectView(contextPath + "adminUpdateSales");
		
	}
	
	@RequestMapping("admin/adminDeleteSales")
	public ModelAndView getSalesDataDelete()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("PRODUCTS",adminProductApplication.getAllSalesData());
		modelAndView.setViewName("admin/adminDeleteSale");
		return modelAndView;
	}
	
	@RequestMapping("admin/getSelectedSaleDataDelete")
	public ModelAndView getSelectedSaleDataDelete(@RequestParam("productId") Integer productId)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("SELECTEDSALE",adminProductApplication.getSelectedSale(productId));
		modelAndView.addObject("PRODUCTS",adminProductApplication.getAllSalesDataExceptSelected(productId));
		modelAndView.setViewName("admin/adminDeleteSale");
		return modelAndView;
	
	}
	
	@RequestMapping(value= "admin/deleteSaleData",method = RequestMethod.POST )
	public RedirectView deleteSale(@RequestParam("productId") Integer productId,HttpServletRequest request)
	{
		adminProductApplication.deleteSaleData(productId);
		
		String contextPath = request.getContextPath();
	    return new RedirectView(contextPath + "adminDeleteSales");
		
	}
	
	@RequestMapping("admin/adminAllProducts")
	public ModelAndView getAdminAllProducts()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("PRODUCTS",adminProductApplication.getAllProducts());
		modelAndView.setViewName("admin/adminAllProduct");
		return modelAndView;
		
	}
	
	
}
