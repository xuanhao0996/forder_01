package com.framgia.bean;

import java.util.List;

public class PaymentInfo {

	private Integer id;
	private String paymentMethod;
	private Integer status;
	private List<OrderInfo> orders;
	public PaymentInfo() {
	}
	public PaymentInfo(Integer id, String paymentMethod, Integer status, List<OrderInfo> orders) {
		this.id = id;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.orders = orders;
	}
	public PaymentInfo(String paymentMethod, Integer status, List<OrderInfo> orders) {
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.orders = orders;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<OrderInfo> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderInfo> orders) {
		this.orders = orders;
	}
}
