package com.framgia.model;

import java.util.ArrayList;
import java.util.List;

import com.framgia.entity.CartDetail;
import com.framgia.entity.User;

public class CartInfo {
	private Integer id;
	private User user;
	private Integer status;
	private List<CartDetail> cartDetails = new ArrayList<CartDetail>();

	public CartInfo() {
	}

	public CartInfo(Integer id) {
		this.id = id;
	}

	public CartInfo(Integer id, User user, Integer status, List<CartDetail> cartDetails) {
		this.id = id;
		this.user = user;
		this.status = status;
		this.cartDetails = cartDetails;
	}

	public CartInfo(User user, Integer status, List<CartDetail> cartDetails) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}
}
