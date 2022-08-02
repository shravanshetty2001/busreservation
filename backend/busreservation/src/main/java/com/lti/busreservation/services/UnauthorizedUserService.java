package com.lti.busreservation.service;

import com.lti.busreservation.dto.UnauthorizedUserDto;
import com.lti.busreservation.models.Unauthorizeduser;

public interface UnauthorizedUserService {
	
	public boolean addUnauthorizedUser(UnauthorizedUserDto undto);
	public UnauthorizedUserDto getUnauthorizeduser(int id);

}
