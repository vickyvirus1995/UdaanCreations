package com.vickyvirus.udaan.admin.application;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.vickyvirus.udaan.admin.dao.AdminProductDao;
import com.vickyvirus.udaan.admin.dao.AdminSaleProductDao;
import com.vickyvirus.udaan.admin.entity.Sale;
import com.vickyvirus.udaan.entity.Product;

@Component
public class AdminProductApplication {

	@Autowired
	private AdminProductDao adminProductDao;
	@Autowired
	private AdminSaleProductDao adminSaleProductDao;
	
	private static String UPLOADED_FOLDER = "src//main//webapp//ProductImages//";
	
	
	
	
	public Product addProduct(String productName,String productQuantity,Integer productPrice,MultipartFile productImage)
	{
		try {
			
				
			byte[] imageInByte = productImage.getBytes();
			FileCopyUtils.copy(imageInByte, new File("src/main/resources"+productImage.getOriginalFilename()));
			//Path path = Paths.get(UPLOADED_FOLDER + productImage.getOriginalFilename());
			//Files.write(path, imageInByte);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			Product product = new Product();
			product.setProductName(productName);
			product.setProductQuantity(productQuantity);
			product.setProductPrice(productPrice);
			product.setProductImage(productImage.getOriginalFilename());
			
			Product check_product = adminProductDao.addProduct(product);
			
			return check_product;
	}
	
	public List<Product> getAllProducts()
	{
		List<Product> allProduct = adminProductDao.getAllProduct();
		return allProduct;
	}

	public Product addProductForEdit(String name, String quantity, Integer price, MultipartFile image) {
		Product product = new Product();
		product.setProductName(name);
		product.setProductQuantity(quantity);
		product.setProductPrice(price);
		product.setProductImage(image.getOriginalFilename());
		
		return product;
	}

	public Product getProductById(Integer product_id) {
		Product product = adminProductDao.getProductById(product_id);
		return product;
	}

	public List<Product> getAllProductsExceptSelected(Integer product_id) {
		List<Product> products= adminProductDao.getAllProductsExceptSelected(product_id);
		return products;
	}

	public void updateProduct(Integer productId, String productName, String productQuantity, Integer productPrice,
			MultipartFile productImage) {
		
		try {
			
			byte[] imageInByte = productImage.getBytes();
			
			Path path = Paths.get(UPLOADED_FOLDER + productImage.getOriginalFilename());
			Files.write(path, imageInByte);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			Product product = new Product();
			product.setProductId(productId);
			product.setProductName(productName);
			product.setProductQuantity(productQuantity);
			product.setProductPrice(productPrice);
			product.setProductImage(productImage.getOriginalFilename());
			
			adminProductDao.updateProduct(product);
			
			
		
	}

	public void deleteProduct(Integer productId) {
		adminProductDao.deleteProduct(productId);
		
	}

	public void saveSaleProduct(String productName, Integer productPrice,
			Integer productDiscountedPrice, String productImage,String productOffer) {
		Sale sale = new Sale();
		sale.setProductName(productName);
		sale.setProductPrice(productPrice);
		sale.setProductDiscountedPrice(productDiscountedPrice);
		sale.setProductOffer(productOffer);
		sale.setProductImage(productImage);
		
		adminSaleProductDao.saveSaleProduct(sale);
		
	}

	public List<Sale> getAllSalesData() {
		
		return adminSaleProductDao.getAllSalesData();
	}

	public Sale getSelectedSale(Integer productId) {
		
		return adminSaleProductDao.getSelectedSale(productId);
	}

	public List<Sale> getAllSalesDataExceptSelected(Integer productId) {
		
		return adminSaleProductDao.getAllSalesDataExceptSelected(productId);
	}

	public void updateSaleProduct(Integer productId,String productName, Integer productPrice, Integer productDiscountedPrice,
			String productImage, String productOffer) {
		
		Sale sale = new Sale();
		sale.setProductId(productId);
		sale.setProductName(productName);
		sale.setProductPrice(productPrice);
		sale.setProductDiscountedPrice(productDiscountedPrice);
		sale.setProductOffer(productOffer);
		sale.setProductImage(productImage);
		
		adminSaleProductDao.updateSaleProduct(sale);
		
	}

	public void deleteSaleData(Integer productId) {
		adminSaleProductDao.deleteSaleData(productId);
		
	}

	
}
