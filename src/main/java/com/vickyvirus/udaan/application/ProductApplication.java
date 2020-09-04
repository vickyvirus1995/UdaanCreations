package com.vickyvirus.udaan.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vickyvirus.udaan.entity.Product;
import com.vickyvirus.udaan.service.ProductDaoImpl;

@Component
public class ProductApplication {

	@Autowired
	private ProductDaoImpl productDaoImpl;

	public List<Product> getLatestProducts() {
		
		return productDaoImpl.getLatestProducts();
	}
}
