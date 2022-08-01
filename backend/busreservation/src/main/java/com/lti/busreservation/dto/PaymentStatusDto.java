package com.lti.busreservation.dto;

public class PaymentStatusDto {
	
	boolean status;
	String errMessage;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	

}
