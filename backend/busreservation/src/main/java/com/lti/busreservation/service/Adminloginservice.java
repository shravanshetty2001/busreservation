package com.lti.busreservation.service;

import javax.validation.Valid;

import com.lti.busreservation.dto.AdminloginDto;
import com.lti.busreservation.dto.AdminregisterDto;
import com.lti.busreservation.dto.AdminstatusDto;
import com.lti.busreservation.models.Admin;

public interface Adminloginservice {
	public AdminstatusDto registerData(AdminregisterDto adminregisterDto);
	public AdminstatusDto verifyData(AdminloginDto adminloginDto);
}
