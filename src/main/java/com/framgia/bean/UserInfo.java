package com.framgia.bean;

import java.util.List;

public class UserInfo {
	private Integer id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private String role;
	private List<OrderInfo> orders;
	private List<CartInfo> carts;

	public UserInfo() {
	}

	public UserInfo(String email,String name, String phone) {
		this.email = email;
		this.name = name;
		this.phone = phone;
	}
	
	
	
	public UserInfo(Integer id, String email, String password, String name, String phone, String role,
			List<OrderInfo> orders, List<CartInfo> carts) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.role = role;
		this.orders = orders;
		this.carts = carts;
	}

	public UserInfo(Integer id, String email, String password, String name, String phone, String role,
			List<CartInfo> carts){
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.role = role;
		this.carts = carts;
	}

	public UserInfo(String email, String password, String name, String phone, String role, List<CartInfo> carts) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<CartInfo> getCarts() {
		return carts;
	}

	public void setCarts(List<CartInfo> carts) {
		this.carts = carts;
	}

	public List<OrderInfo> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderInfo> orders) {
		this.orders = orders;
	}
	
	
}
