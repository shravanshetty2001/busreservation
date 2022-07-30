package com.lti.busreservation.dto;


public class AdminregisterDto {
	private String email;
	private String password;
	private String travelname;
	private String contactno;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTravelname() {
		return travelname;
	}
	public void setTravelname(String travelname) {
		this.travelname = travelname;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
}