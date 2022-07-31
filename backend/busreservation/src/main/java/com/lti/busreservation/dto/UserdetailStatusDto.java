package com.lti.busreservation.dto;

public class UserdetailStatusDto {
	boolean status;
	String errorMessge;
	UserdetailDto userdetailDto;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getErrorMessge() {
		return errorMessge;
	}
	public void setErrorMessge(String errorMessge) {
		this.errorMessge = errorMessge;
	}
	public UserdetailDto getUserdetailDto() {
		return userdetailDto;
	}
	public void setUserdetailDto(UserdetailDto userdetailDto) {
		this.userdetailDto = userdetailDto;
	}
	
	
}
