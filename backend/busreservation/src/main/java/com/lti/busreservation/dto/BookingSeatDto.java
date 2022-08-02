package com.lti.busreservation.dto;


public class BookingSeatDto {

	private int seatno;
	private int bustimetable; 
	private String email;
	private String phoneno;
	private String username;
	private int userId;
	
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
	public int getSeatno() {
		return seatno;
	}
	public int getBustimetable() {
		return bustimetable;
	}
	public void setBustimetable(int bustimetable) {
		this.bustimetable = bustimetable;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
