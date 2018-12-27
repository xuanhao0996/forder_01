package com.framgia.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryInfo {
	private Integer id;
	private String name;
	private Integer type;
	private Date dateCreate;
	private List<ProductInfo> products = new ArrayList<ProductInfo>();
	public CategoryInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryInfo(String name, Integer type, Date dateCreate, List<ProductInfo> products) {
		super();
		this.name = name;
		this.type = type;
		this.dateCreate = dateCreate;
		this.products = products;
	}
	public CategoryInfo(Integer id, String name, Integer type, Date dateCreate, List<ProductInfo> products) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.dateCreate = dateCreate;
		this.products = products;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	public List<ProductInfo> getProducts() {
		return products;
	}
	public void setProducts(List<ProductInfo> products) {
		this.products = products;
	}

}
