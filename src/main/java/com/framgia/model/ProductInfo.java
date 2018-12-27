package com.framgia.model;

import java.util.Date;


public class ProductInfo {
	private Integer id;
	private CategoryInfo category;
	private String name;
	private float price;
	private String code;
	private String image;
	private String desciption;
	private Date expiryDate;

	public ProductInfo() {
	}
	
	public ProductInfo(Integer id) {
		this.id = id;
	}

	public ProductInfo(Integer id, CategoryInfo category, String name, float price, String code, String image,
			String desciption, Date expiryDate) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.code = code;
		this.image = image;
		this.desciption = desciption;
		this.expiryDate = expiryDate;

	}

	public ProductInfo(CategoryInfo category, String name, float price, String code, String image, String desciption,
			Date expiryDate) {
		super();
		this.category = category;
		this.name = name;
		this.price = price;
		this.code = code;
		this.image = image;
		this.desciption = desciption;
		this.expiryDate = expiryDate;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CategoryInfo getCategory() {
		return category;
	}

	public void setCategory(CategoryInfo category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}



	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}