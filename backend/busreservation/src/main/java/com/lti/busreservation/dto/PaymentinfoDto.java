package com.lti.busreservation.dto;

import java.sql.Timestamp;

public class PaymentinfoDto {

	int id;
	Timestamp paymentDatetime;
	double amount;
	boolean paymentType; //true:credit     and       false:debit
	int bookingId;
	int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getPaymentDatetime() {
		return paymentDatetime;
	}
	public void setPaymentDatetime(Timestamp paymentDatetime) {
		this.paymentDatetime = paymentDatetime;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isPaymentType() {
		return paymentType;
	}
	public void setPaymentType(boolean paymentType) {
		this.paymentType = paymentType;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
