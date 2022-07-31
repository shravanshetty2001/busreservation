package com.lti.busreservation.services;

import java.util.List;


import com.lti.busreservation.dto.LoginDto;
import com.lti.busreservation.dto.UserdetailDto;
import com.lti.busreservation.dto.UserdetailRegisterDto;
import com.lti.busreservation.dto.UserdetailStatusDto;

public interface UserdetailService {
	UserdetailStatusDto verifyUser(LoginDto loginDto);
	List<UserdetailDto> getAllUserdetail();
	UserdetailStatusDto addUserdetail(UserdetailRegisterDto userdetailDto);
	
}
