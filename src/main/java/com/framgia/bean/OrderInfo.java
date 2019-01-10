package com.framgia.bean;

import java.util.Date;

public class OrderInfo {
	private Integer id;
	private PaymentInfo payment;
	//private ShippingInfo shippingInfo;
	private UserInfo user;
	private Date createDate;
	private float totalBill;
	private String status;
	//private List<OrderDetail> orderDetails = new ArrayList<>();
	public OrderInfo() {
	}
	public OrderInfo(Integer id, UserInfo user, Date createDate, float totalBill,
			String status, PaymentInfo paymentInfo) {
		this.id = id;
		this.user = user;
		this.createDate = createDate;
		this.totalBill = totalBill;
		this.status = status;
		this.payment= paymentInfo;
	}
	public OrderInfo(UserInfo user, Date createDate, float totalBill,
			String status, PaymentInfo paymentInfo) {
		this.user = user;
		this.createDate = createDate;
		this.totalBill = totalBill;
		this.status = status;
		this.payment= paymentInfo;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public float getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(float totalBill) {
		this.totalBill = totalBill;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PaymentInfo getPayment() {
		return payment;
	}
	public void setPayment(PaymentInfo payment) {
		this.payment = payment;
	}
	
}
