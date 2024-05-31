package com.srihari.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer productId ;
	 
	 private String productName;
	 
	 private String  productCategory;

	 private String productDescription;
	
	 private Float productPrice;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(Integer productId, String productName, String productCategory, String productDescription,
			Float productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
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

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productDescription=" + productDescription + ", productPrice=" + productPrice
				+ "]";
	}
	 
	 
	
}
