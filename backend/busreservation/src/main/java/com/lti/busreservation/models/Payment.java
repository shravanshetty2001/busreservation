package com.lti.busreservation.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	@Id
//	@SequenceGenerator(name="payment_id",initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="paymentdatetime")
	Timestamp paymentDatetime;
	@Column(name="amount")
	double amount;
	@Column(name="paymentType")
	boolean paymentType;
	@ManyToOne
	@JoinColumn(name="userid")
	Userdetail userdetail;
	
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
	

}
