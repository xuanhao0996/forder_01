package com.framgia.model;
// Generated Dec 14, 2018 4:21:20 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;

/**
 * Reviews generated by hbm2java
 */
public class Review {

	private Integer id;
	private Product product;
	private String name;
	private String email;
	private Integer rating;
	private String review;
	private Date date;

	public Review() {
	}

	public Review(Product product, String name, String email, Integer rating, String review, Date date) {
		super();
		this.product = product;
		this.name = name;
		this.email = email;
		this.rating = rating;
		this.review = review;
		this.date = date;
	}

	public Review(Integer id, Product product, String name, String email, Integer rating, String review, Date date) {
		super();
		this.id = id;
		this.product = product;
		this.name = name;
		this.email = email;
		this.rating = rating;
		this.review = review;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
