package com.framgia.bean;
// Generated Dec 14, 2018 4:21:20 PM by Hibernate Tools 4.3.5.Final

/**
 * CartDetail generated by hbm2java
 */
public class CartDetailInfo {

	private Integer id;
	private CartInfo cart;
	private ProductInfo product;
	private int quantity;
	public CartDetailInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDetailInfo(CartInfo cart, ProductInfo product, int quantity) {
		super();
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}
	public CartDetailInfo(Integer id, CartInfo cart, ProductInfo product, int quantity) {
		super();
		this.id = id;
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CartInfo getCartInfo() {
		return cart;
	}
	public void setCartInfo(CartInfo cart) {
		this.cart = cart;
	}
	public ProductInfo getProductInfo() {
		return product;
	}
	public void setProductInfo(ProductInfo product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
