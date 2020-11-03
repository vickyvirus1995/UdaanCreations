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

	public List<Product> getAllProducts(String numberOfRecords) {
		
		return productDao.getAllProducts(numberOfRecords);
	}
	
	public List<Sale> getLatestSalesProducts() {
		
		return salesProductDao.getLatestSalesProducts();
	}

	public List<Sale> getAllSalesProducts(String numberOfRecords) {
		return salesProductDao.getAllSalesProducts(numberOfRecords);
		
	}

	public List<Product> getSearchProducts(String searchKeyword) {
		
		return productDao.getSearchProducts(searchKeyword);
	}

	

	public List<Product> sortByType(String sortType) {
		if(sortType.equals("Sort By Price"))
		{
			return productDao.sortByPrice();
		}
		else if(sortType.equals("Sort By Popularity"))
		{
			return productDao.sortByPopularity();
		}
		
		return null;
	}

	public List<Sale> sortSalesProductsByType(String sortType) {
		if(sortType.equals("Sort By Price"))
		{
			return salesProductDao.sortByPrice();
		}
		else if(sortType.equals("Sort By Popularity"))
		{
			return salesProductDao.sortByPopularity();
		}
		
		return null;
	}

	public Product getSelectedProduct(Integer productId) {
		
		return productDao.getSelectedProduct(productId);
	}

	public Sale getSelectedSaleProduct(Integer productId) {
		
		return salesProductDao.getSelectedSaleProduct(productId);
	}

	
}
