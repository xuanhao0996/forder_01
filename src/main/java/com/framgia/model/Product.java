package com.framgia.model;
// Generated Dec 14, 2018 4:21:20 PM by Hibernate Tools 4.3.5.Final

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Products generated by hbm2java
 */
public class Product implements java.io.Serializable {

	private Integer id;
	private Category categories;
	private String name;
	private float price;
	private String code;
	private String images;
	private String desciption;
	private Date expiryDate;
	private List<Review> reviews = new ArrayList<>();
	private List<OrderDetail> orderDetails = new ArrayList<>();
	private List<CartDetail> cartDetails = new ArrayList<>();

	public Product() {
	}

	public Product(Category categories, String name, float price) {
		this.categories = categories;
		this.name = name;
		this.price = price;
	}

	public Product(Category categories, String name, float price, String code, String images, String desciption,
			Date expiryDate, List<Review> reviews, List<OrderDetail> orderDetails, List<CartDetail> cartDetails) {
		this.categories = categories;
		this.name = name;
		this.price = price;
		this.code = code;
		this.images = images;
		this.desciption = desciption;
		this.expiryDate = expiryDate;
		this.reviews = reviews;
		this.orderDetails = orderDetails;
		this.cartDetails = cartDetails;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategories() {
		return this.categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getDesciption() {
		return this.desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<CartDetail> getCartDetails() {
		return this.cartDetails;
	}

	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

}
