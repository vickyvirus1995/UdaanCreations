package com.vickyvirus.udaan.admin.application;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
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
	
	public byte[] base64ToBytes(String base64Image)
	{
		return Base64.getDecoder().decode(new String(base64Image).getBytes());
	}
	
	
	public Product addProduct(String productName,String productQuantity,Integer productPrice,MultipartFile productImage)
	{
		Product product = new Product();
		try {
			
				
	
			product.setProductName(productName);
			product.setProductQuantity(productQuantity);
			product.setProductPrice(productPrice);
		
			product.setProductImage(productImage.getBytes());
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
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
		try {
		
		product.setProductName(name);
		product.setProductQuantity(quantity);
		product.setProductPrice(price);
		product.setProductImage(image.getBytes());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
		
		Product product = new Product();
		try {
			
			product.setProductId(productId);
			product.setProductName(productName);
			product.setProductQuantity(productQuantity);
			product.setProductPrice(productPrice);
			product.setProductImage(productImage.getBytes());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
			
			adminProductDao.updateProduct(product);
			
			
		
	}

	public void updateProduct(Integer productId, String productName, String productQuantity, Integer productPrice,
			String oldProductImage) {
		
		Product product = new Product();
	
			product.setProductId(productId);
			product.setProductName(productName);
			product.setProductQuantity(productQuantity);
			product.setProductPrice(productPrice);
			product.setProductImage(base64ToBytes(oldProductImage));
			adminProductDao.updateProduct(product);
	}
	
	public void deleteProduct(Integer productId) {
		adminProductDao.deleteProduct(productId);
		
	}

	public void saveSaleProduct(String productName, Integer productPrice,
			Integer productDiscountedPrice, String productImage,String productOffer) {
		try {
			
		Sale sale = new Sale();
		sale.setProductName(productName);
		sale.setProductPrice(productPrice);
		sale.setProductDiscountedPrice(productDiscountedPrice);
		sale.setProductOffer(productOffer);
		sale.setProductImage(base64ToBytes(productImage));
		
		adminSaleProductDao.saveSaleProduct(sale);
		}catch(Exception e)
		{ e.printStackTrace();}
		
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
			String productOffer,String productImage) {
		
		Sale sale = new Sale();
		sale.setProductId(productId);
		sale.setProductName(productName);
		sale.setProductPrice(productPrice);
		sale.setProductDiscountedPrice(productDiscountedPrice);
		sale.setProductOffer(productOffer);
		sale.setProductImage(base64ToBytes(productImage));
		
		
		adminSaleProductDao.updateSaleProduct(sale);
		
	}

	public void deleteSaleData(Integer productId) {
		adminSaleProductDao.deleteSaleData(productId);
		
	}


	

	
}
