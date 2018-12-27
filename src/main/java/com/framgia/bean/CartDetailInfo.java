package com.framgia.bean;

import com.framgia.model.Cart;

public class CartDetailInfo {
	private Integer id;
	private Cart cart;
	private ProductInfo product;
	private int quantity;

	public CartDetailInfo() {
	}

	public CartDetailInfo(Cart cart, ProductInfo product) {
		this.cart = cart;
		this.product = product;
	}

	public CartDetailInfo(Cart cart, ProductInfo product, int quantity) {
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}

	public CartDetailInfo(Integer id, Cart cart, ProductInfo product, int quantity) {
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
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
