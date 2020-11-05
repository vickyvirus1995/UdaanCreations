package com.vickyvirus.udaan.admin.entity;

import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

@Entity
public class Sale {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer productId;
	
	private String productName;
	private Integer productPrice;
	private Integer productDiscountedPrice;
	private String productOffer;
	@Lob
	private byte[] productImage;
	@Transient
	private String saleBase64Image;
	 
	 
    @Transient
    public String getSaleBase64Image() {
    	 saleBase64Image = Base64.getEncoder().encodeToString(this.productImage);
    	return saleBase64Image;
	}
	public void setSaleBase64Image(String saleBase64Image) {
		this.saleBase64Image = saleBase64Image;
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
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	
	
	
		
}
