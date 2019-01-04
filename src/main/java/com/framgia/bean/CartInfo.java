package com.framgia.bean;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {
	private Integer id;
	private UserInfo user;
	private Integer status;
	private List<CartDetailInfo> cartDetails = new ArrayList<CartDetailInfo>();

	public CartInfo() {
	}

	public CartInfo(Integer id) {
		this.id = id;
	}

	public CartInfo(Integer id, UserInfo user, Integer status, List<CartDetailInfo> cartDetails) {
		this.id = id;
		this.user = user;
		this.status = status;
		this.cartDetails = cartDetails;
	}

	public CartInfo(UserInfo user, Integer status, List<CartDetailInfo> cartDetails) {
		this.user = user;
		this.status = status;
		this.cartDetails = cartDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<CartDetailInfo> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetailInfo> cartDetails) {
		this.cartDetails = cartDetails;
	}
}
