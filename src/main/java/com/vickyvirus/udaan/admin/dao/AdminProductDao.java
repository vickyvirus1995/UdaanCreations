package com.vickyvirus.udaan.admin.dao;

import java.util.List;

import com.vickyvirus.udaan.entity.Product;

public interface AdminProductDao {

	public Product addProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public List<Product> getAllProductsExceptSelected(Integer product_id);
	
	public Product getProductById(Integer product_id);
	
}
