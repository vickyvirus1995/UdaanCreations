package com.vickyvirus.udaan.dao;

import java.util.List;

import com.vickyvirus.udaan.admin.entity.Sale;
import com.vickyvirus.udaan.entity.Product;

public interface ProductDao {

	public List<Product> getLatestProducts();

	public List<Product> getAllProducts(String numberOfRecords);

	public List<Product> getSearchProducts(String searchKeyword);

	public List<Product> sortByPrice();

	public List<Product> sortByPopularity();

	public Product getSelectedProduct(Integer productId);

	
}
