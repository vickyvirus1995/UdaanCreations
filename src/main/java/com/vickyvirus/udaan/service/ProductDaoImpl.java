package com.vickyvirus.udaan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	

}
