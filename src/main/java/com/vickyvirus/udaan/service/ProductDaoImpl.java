package com.vickyvirus.udaan.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vickyvirus.udaan.admin.entity.Sale;
import com.vickyvirus.udaan.dao.ProductDao;
import com.vickyvirus.udaan.entity.Product;
import com.vickyvirus.udaan.repository.ProductRepository;

@Service
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getLatestProducts() {
		
		return productRepository.getLatestProducts();
		
	}

	@Override
	public List<Product> getAllProducts(String numberOfRecords) {
		if(!numberOfRecords.equals("all"))
			return productRepository.getAllProducts(Integer.parseInt(numberOfRecords));
		else
			return productRepository.findAll();
	}

	@Override
	public List<Product> getSearchProducts(String searchKeyword) {
		
		return productRepository.getSearchProducts(searchKeyword);
	}

	@Override
	public List<Product> sortByPrice() {
		List<Product> products = productRepository.findAll();
		List<Product> sortedProducts = products.stream().sorted((p1,p2)->p1.getProductPrice().compareTo(p2.getProductPrice())).collect(Collectors.toList());
		
		return sortedProducts;
	}

	@Override
	public List<Product> sortByPopularity() {
		return productRepository.findByOrderByProductIdDesc();
		
	}

	@Override
	public Product getSelectedProduct(Integer productId) {
		
		return productRepository.findById(productId).orElse(null);
	}

	
	
	
}
