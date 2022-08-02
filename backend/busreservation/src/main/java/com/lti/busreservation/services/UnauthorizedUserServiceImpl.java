package com.lti.busreservation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.dto.UnauthorizedUserDto;
import com.lti.busreservation.models.Unauthorizeduser;
import com.lti.busreservation.repository.UnauthorizedUserRepository;

@Service
public class UnauthorizedUserServiceImpl implements UnauthorizedUserService{

	@Autowired
	private UnauthorizedUserRepository unauthorizedUserRepository;
	
	
	
	@Override
	public boolean addUnauthorizedUser(UnauthorizedUserDto undto) {
		// TODO Auto-generated method stub
		Unauthorizeduser unauthorizeduser = new Unauthorizeduser();
		unauthorizeduser.setEmail(undto.getEmail());
		unauthorizeduser.setPhoneno(undto.getPhoneno());

		unauthorizedUserRepository.save(unauthorizeduser);
		
		return true;
	}



	@Override
	public UnauthorizedUserDto getUnauthorizeduser(int id) {
		// TODO Auto-generated method stub
		
		Unauthorizeduser unauthorizeduser = new Unauthorizeduser();
		Optional<Unauthorizeduser> UnauthorizeduserEntity = unauthorizedUserRepository.findById(id);
		unauthorizeduser = UnauthorizeduserEntity.get();
		
		UnauthorizedUserDto dto = new UnauthorizedUserDto();
		dto.setEmail(unauthorizeduser.getEmail());
		dto.setPhoneno(unauthorizeduser.getPhoneno());
		dto.setBooking(unauthorizeduser.getBooking().getId());
		
		return dto;
	}

	
}
