package com.framgia.bean;

public class UserInfo {
	private Integer id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private int role;
	
	public UserInfo() {
		
	}

	public UserInfo(String email, String password, String name, String phone, int role) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.role = role;
	}

	public UserInfo(Integer id, String email, String password, String name, String phone, int role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.role = role;
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
	
	
}
