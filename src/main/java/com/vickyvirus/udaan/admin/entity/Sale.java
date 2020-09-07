package com.vickyvirus.udaan.admin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sale {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer productId;
	
	private String productName;
	private Integer productPrice;
	private Integer productDiscountedPrice;
	private String productOffer;
	private String productImage;
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
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductDiscountedPrice() {
		return productDiscountedPrice;
	}
	public void setProductDiscountedPrice(Integer productDiscountedPrice) {
		this.productDiscountedPrice = productDiscountedPrice;
	}
	public String getProductOffer() {
		return productOffer;
	}
	public void setProductOffer(String productOffer) {
		this.productOffer = productOffer;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
		
}
