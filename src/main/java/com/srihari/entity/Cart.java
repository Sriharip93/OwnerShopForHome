package com.srihari.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer cartId;
	 
	 private Integer  productId;
	 
	 private String productname;
	 
	 private Integer quantity;

	public Cart() {
		
		super();
		
	}

	public Cart(Integer cartId, Integer productId, String productname, Integer quantity) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.productname = productname;
		this.quantity = quantity;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productId=" + productId + ", productname=" + productname + ", quantity="
				+ quantity + "]";
	}
	 
	 
}
