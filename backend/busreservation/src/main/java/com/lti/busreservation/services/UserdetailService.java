package com.lti.busreservation.services;

import java.util.List;


import com.lti.busreservation.dto.LoginDto;
import com.lti.busreservation.dto.UserdetailDto;
import com.lti.busreservation.models.Userdetail;

public interface UserdetailService {
	Userdetail verifyUser(LoginDto loginDto);
	List<Userdetail> getAllUserdetail();
	Userdetail addUserdetail(UserdetailDto userdetailDto);
	
}
