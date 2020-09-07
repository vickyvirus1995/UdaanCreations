package com.vickyvirus.udaan.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vickyvirus.udaan.admin.dao.AdminProductDao;
import com.vickyvirus.udaan.entity.Product;
import com.vickyvirus.udaan.repository.ProductRepository;

@Service
public class AdminProductDaoImpl implements AdminProductDao{

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

	@Override
	public Product getProductById(Integer product_id) {
		return productRepository.findById(product_id).orElse(null);
		
	}

	@Override
	public List<Product> getAllProductsExceptSelected(Integer product_id) {
		List<Product> products = productRepository.find(product_id);
		return products;
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void deleteProduct(Integer productId) {
		productRepository.deleteById(productId);
		
	}

}
