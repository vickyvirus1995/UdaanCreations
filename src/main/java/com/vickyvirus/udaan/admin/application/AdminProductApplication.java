package com.vickyvirus.udaan.admin.application;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.vickyvirus.udaan.admin.service.AdminProductDaoImpl;
import com.vickyvirus.udaan.entity.Product;

@Component
public class AdminProductApplication {

	@Autowired
	private AdminProductDaoImpl adminProductDaoImpl;
	
	private static String UPLOADED_FOLDER = "src//main//webapp//Product Images//";
	
	
	
	
	public Product addProduct(String name,String quantity,String price,MultipartFile image)
	{
		try {
					
			byte[] imageInByte = image.getBytes();
			
			Path path = Paths.get(UPLOADED_FOLDER + image.getOriginalFilename());
			Files.write(path, imageInByte);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			Product product = new Product();
			product.setName(name);
			product.setQuantity(quantity);
			product.setPrice(price);
			product.setImage(image.getOriginalFilename());
			
			Product check_product = adminProductDaoImpl.addProduct(product);
			
			return check_product;
	}
	
	public List<Product> getAllProducts()
	{
		List<Product> allProduct = adminProductDaoImpl.getAllProduct();
		return allProduct;
	}

	public Product addProductForEdit(String name, String quantity, String price, MultipartFile image) {
		Product product = new Product();
		product.setName(name);
		product.setQuantity(quantity);
		product.setPrice(price);
		product.setImage(image.getOriginalFilename());
		
		return product;
	}

	public Product getProductById(Integer product_id) {
		Product product = adminProductDaoImpl.getProductById(product_id);
		return product;
	}

	public List<Product> getAllProductsExceptSelected(Integer product_id) {
		List<Product> products= adminProductDaoImpl.getAllProductsExceptSelected(product_id);
		return products;
	}

	
}
