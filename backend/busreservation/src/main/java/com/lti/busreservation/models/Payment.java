package com.lti.busreservation.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="paymentdatetime")
	Timestamp paymentDatetime;
	@Column(name="amount")
	double amount;
	@Column(name="paymentType")
	boolean paymentType; //true:credit     and       false:debit
	@ManyToOne
	@JoinColumn(name="userid")
	Userdetail userdetail;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bookid")
	Booking booking;

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
	public Userdetail getUserdetail() {
		return userdetail;
	}
	public void setUserdetail(Userdetail userdetail) {
		this.userdetail = userdetail;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	
	

}
