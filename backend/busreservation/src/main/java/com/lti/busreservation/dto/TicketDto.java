package com.lti.busreservation.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class TicketDto {

	private int seatno;
	private String route;
	private String sourceplace;
	private String destplace;
	private Timestamp date;
	private long time;
	private String name;
	private String phoneno;
	private Timestamp bookedOn;
	private double price;
	
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Timestamp getBookedOn() {
		return bookedOn;
	}
	public void setBookedOn(Timestamp timestamp) {
		this.bookedOn = timestamp;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getSourceplace() {
		return sourceplace;
	}
	public void setSourceplace(String sourceplace) {
		this.sourceplace = sourceplace;
	}
	public String getDestplace() {
		return destplace;
	}
	public void setDestplace(String destplace) {
		this.destplace = destplace;
	}
	
	public long getTime() {
		return time;
	}
	public void setTime(long l) {
		this.time = l;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	
	
	
}
