package com.vickyvirus.udaan.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vickyvirus.udaan.admin.entity.Sale;
import com.vickyvirus.udaan.dao.ProductDao;
import com.vickyvirus.udaan.dao.SalesProductDao;
import com.vickyvirus.udaan.entity.Product;

@Component
public class ProductApplication {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private SalesProductDao salesProductDao;

	public List<Product> getLatestProducts() {
		
		return productDao.getLatestProducts();
	}

	public List<Product> getAllProducts() {
		
		return productDao.getAllProducts();
	}
	
	public List<Sale> getLatestSalesProducts() {
		
		return salesProductDao.getLatestSalesProducts();
	}

	public List<Sale> getAllSalesProducts() {
		return salesProductDao.getAllSalesProducts();
		
	}

	
}
