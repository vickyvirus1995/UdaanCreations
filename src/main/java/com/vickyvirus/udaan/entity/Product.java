package com.vickyvirus.udaan.entity;

import java.io.File;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

@Entity
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private String productQuantity;
	private Integer productPrice;
	@Lob
	private byte[] productImage;
	@Transient
	private String productBase64Image;
    
	@Transient
    public String getProductBase64Image() {
    	productBase64Image = Base64.getEncoder().encodeToString(this.productImage);
    	return productBase64Image;
	}

	public void setProductBase64Image(String productBase64Image) {
		this.productBase64Image = productBase64Image;
	}

	
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] bs) {
		this.productImage = bs;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", productPrice=" + productPrice + ", productImage=" + productImage + "]";
	}
	
	
	
	
}
