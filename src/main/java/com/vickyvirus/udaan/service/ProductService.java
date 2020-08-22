package com.vickyvirus.udaan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vickyvirus.udaan.dao.ProductDao;
import com.vickyvirus.udaan.entity.Product;
import com.vickyvirus.udaan.repository.ProductRepository;

@Service
public class ProductService implements ProductDao{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		Product product_values = productRepository.save(product);
		if(product.equals(null))
		{
			System.out.println("Error while storing");
		}
		return product_values;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> allProducts = productRepository.findAll();
		return allProducts;
	}

}
