package com.framgia.bean;

public class OrderDetailInfo {
	private Integer id;
	private OrderInfo order;
	private ProductInfo product;
	private float productPrice;
	private int quantity;
	public OrderDetailInfo() {
	}
	public OrderDetailInfo(Integer id, OrderInfo order, ProductInfo product, float productPrice, int quantity) {
		this.id = id;
		this.order = order;
		this.product = product;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}
	public OrderDetailInfo(OrderInfo order, ProductInfo product, float productPrice, int quantity) {
		this.order = order;
		this.product = product;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public OrderInfo getOrder() {
		return order;
	}
	public void setOrder(OrderInfo order) {
		this.order = order;
	}
	public ProductInfo getProduct() {
		return product;
	}
	public void setProduct(ProductInfo product) {
		this.product = product;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
