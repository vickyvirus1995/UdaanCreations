package com.vickyvirus.udaan.application;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.vickyvirus.udaan.admin.service.AdminProductDaoImpl;
import com.vickyvirus.udaan.entity.Product;

@Component
public class ProductApplication {

	@Autowired
	private AdminProductDaoImpl productDaoImpl;
	
	private static String UPLOADED_FOLDER = "src//main//webapp//Product Images//";
	
	
	BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
	    Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
	    BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
	    outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
	    return outputImage;
	}
	
	public Product addProduct(String name,String quantity,String price,MultipartFile image)
	{
		try {
			InputStream in = new ByteArrayInputStream(image.getBytes());
			  BufferedImage originalImage = ImageIO.read(in);
			BufferedImage newImage = resizeImage(originalImage, 170, 170);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(newImage, image.getOriginalFilename().split("\\.")[1], baos );
			
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			
			
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
			
			Product check_product = productDaoImpl.addProduct(product);
			
			return check_product;
	}
	
	public List<Product> getAllProducts()
	{
		List<Product> allProduct = productDaoImpl.getAllProduct();
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
		Product product = productDaoImpl.getProductById(product_id);
		return product;
	}

	public List<Product> getAllProductsExceptSelected(Integer product_id) {
		List<Product> products= productDaoImpl.getAllProductsExceptSelected(product_id);
		return products;
	}
}
