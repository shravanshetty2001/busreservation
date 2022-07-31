package com.lti.busreservation.dto;

public class UnauthorizedUserDto {

	private String email;
	private String phoneno;
	private int bookingId;
	
	public int getBooking() {
		return bookingId;
	}
	public void setBooking(int booking) {
		this.bookingId = booking;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
}
