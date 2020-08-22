package com.vickyvirus.udaan.application;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.vickyvirus.udaan.entity.Product;
import com.vickyvirus.udaan.service.ProductService;

@Component
public class ProductApplication {

	@Autowired
	private ProductService productService;
	
	private static String UPLOADED_FOLDER = "src//main//webapp//Product Images//";
	
	public Product addProduct(String name,String quantity,String price,MultipartFile image)
	{
		try {
			byte[] bytes = image.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + image.getOriginalFilename());
			Files.write(path, bytes);
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
			
			Product check_product = productService.addProduct(product);
			
			return check_product;
	}
	
	public List<Product> getAllProducts()
	{
		List<Product> allProduct = productService.getAllProduct();
		return allProduct;
	}
}
