package com.lti.busreservation.dto;

import com.lti.busreservation.models.Admin;

public class AdminstatusDto {
	boolean status;
	String errorMessage;
	AdminDto adminDto;
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public AdminDto getAdmin() {
		return adminDto;
	}
	public void setAdmin(AdminDto admin) {
		this.adminDto = admin;
	}

}
