package com.lti.busreservation.service;

import javax.mail.MessagingException;
import javax.validation.Valid;

import com.lti.busreservation.dto.AdminloginDto;
import com.lti.busreservation.dto.AdminregisterDto;
import com.lti.busreservation.dto.AdminstatusDto;
import com.lti.busreservation.dto.ForgotPasswordDto;
import com.lti.busreservation.models.Admin;

public interface Adminloginservice {
	public AdminstatusDto registerData(AdminregisterDto adminregisterDto);
	public AdminstatusDto verifyData(AdminloginDto adminloginDto);
	AdminstatusDto forgotPassword(ForgotPasswordDto forgotpasswordDto);
	void SendMail(int id, String email) throws MessagingException;
}
