package com.lti.busreservation.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bustimetable")

public class Bustimetable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="s_datetime")
	Timestamp sDatetime; 
	@Column(name="d_datetime")
	Timestamp dDatetime;
	@ManyToOne
	@JoinColumn(name="sidfk")
	Place sourcePlace;
	@ManyToOne
	@JoinColumn(name="didfk")
	Place desnPlace;
	@OneToMany(targetEntity =Booking.class,cascade=CascadeType.ALL)
	List<Booking> booking;
	
	@Column(name="price")
	double price;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getsDatetime() {
		return sDatetime;
	}
	public void setsDatetime(Timestamp sDatetime) {
		this.sDatetime = sDatetime;
	}
	public Timestamp getdDatetime() {
		return dDatetime;
	}
	public void setdDatetime(Timestamp dDatetime) {
		this.dDatetime = dDatetime;
	}
	public Place getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(Place sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public Place getDesnPlace() {
		return desnPlace;
	}
	public void setDesnPlace(Place desnPlace) {
		this.desnPlace = desnPlace;
	}
	public List<Booking> getBooking() {
		return booking;
	}
	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	
	
	
	
	
	

}
