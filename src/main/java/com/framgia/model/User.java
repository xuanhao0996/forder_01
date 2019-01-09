package com.framgia.model;
// Generated Dec 14, 2018 4:21:20 PM by Hibernate Tools 4.3.5.Final

import java.util.ArrayList;

import java.util.List;

/**
 * Users generated by hbm2java
 */
public class User {

	private Integer id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private int role;
	private List<Order> orders = new ArrayList<>();
	private List<Address> addresses = new ArrayList<>();
	private List<Cart> carts = new ArrayList<>();
	public User() {
	}
	public User(Integer id, String email, String password, String name, String phone, int role, List<Order> orders,
			List<Address> addresses, List<Cart> carts) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.role = role;
		this.orders = orders;
		this.addresses = addresses;
		this.carts = carts;
	}
	public User(String email, String password, String name, String phone, int role, List<Order> orders,
			List<Address> addresses, List<Cart> carts) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.role = role;
		this.orders = orders;
		this.addresses = addresses;
		this.carts = carts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public List<Cart> getCarts() {
		return carts;
	}
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	
}
	