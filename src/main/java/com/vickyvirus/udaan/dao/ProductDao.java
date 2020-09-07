package com.vickyvirus.udaan.dao;

import java.util.List;

import com.vickyvirus.udaan.admin.entity.Sale;
import com.vickyvirus.udaan.entity.Product;

public interface ProductDao {

	public List<Product> getLatestProducts();

	public List<Product> getAllProducts();

	
}
