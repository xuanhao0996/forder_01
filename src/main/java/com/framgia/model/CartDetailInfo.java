package com.framgia.model;

public class CartDetailInfo {
	private Integer id;
	private CartInfo cart;
	private ProductInfo product;
	private int quantity;

	public CartDetailInfo() {

	}

	public CartDetailInfo(CartInfo cart, ProductInfo product, int quantity) {
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}

	public CartDetailInfo(Integer id, CartInfo cart, ProductInfo product, int quantity) {
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

	public CartInfo getCart() {
		return cart;
	}

	public void setCart(CartInfo cart) {
		this.cart = cart;
	}

	public ProductInfo getProduct() {
		return product;
	}

	public void setProduct(ProductInfo product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
