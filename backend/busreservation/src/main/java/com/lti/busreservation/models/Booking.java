package com.lti.busreservation.models;

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
@Table(name="bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="bookingstatus")
	String bookingStatus;
	@Column(name="seatno")
	int seatno;
	@OneToOne(cascade = CascadeType.ALL)
	Payment payment;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="btid")
	Bustimetable bustimetable;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="unid")
	Unauthorizeduser unauthorizeduser;
	
	public Unauthorizeduser getUnauthorizeduser() {
		return unauthorizeduser;
	}
	public void setUnauthorizeduser(Unauthorizeduser unauthorizeduser) {
		this.unauthorizeduser = unauthorizeduser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Bustimetable getBustimetable() {
		return bustimetable;
	}
	public void setBustimetable(Bustimetable bustimetable) {
		this.bustimetable = bustimetable;
	}
	
	


}
