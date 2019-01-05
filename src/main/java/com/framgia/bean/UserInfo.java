package com.framgia.bean;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
	private Integer id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private int role;
	// private List<Order> orders = new ArrayList<>();
	// private List<Address> addresses = new ArrayList<>();
	private List<CartInfo> carts = new ArrayList<>();

	public UserInfo() {
	}

	public UserInfo(Integer id, String email, String password, String name, String phone, int role,
			List<CartInfo> carts) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.role = role;
		this.carts = carts;
	}

	public UserInfo(String email, String password, String name, String phone, int role, List<CartInfo> carts) {
		super();
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public List<CartInfo> getCarts() {
		return carts;
	}

	public void setCarts(List<CartInfo> carts) {
		this.carts = carts;
	}

}
