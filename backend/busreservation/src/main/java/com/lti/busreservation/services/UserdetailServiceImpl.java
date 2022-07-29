package com.lti.busreservation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.dto.LoginDto;
import com.lti.busreservation.models.Userdetail;
import com.lti.busreservation.repository.UserdetailRepository;


@Service
public class UserdetailServiceImpl implements UserdetailService{
	
	@Autowired
	private UserdetailRepository userdetailRepository;
	
	
	@Override
	public Userdetail verifyUser(LoginDto loginDto) {
		// TODO Auto-generated method stub
		
		List<Userdetail> ud=userdetailRepository.findAll();
		for(Userdetail u:ud) {
			
			if(u.getEmail().equalsIgnoreCase(loginDto.getEmail())) {
				
				if(u.getPassword().equals(loginDto.getPassword())) {
					return u;
				}
				else {
					break;
				}
				
			}
			
			
		}
		
		return null;
	}


	@Override
	public List<Userdetail> getAllUserdetail() {
		// TODO Auto-generated method stub
		return userdetailRepository.findAll();
	}


	@Override
	public Userdetail addUserdetail(Userdetail userdetail) {
		// TODO Auto-generated method stub
		return userdetailRepository.save(userdetail);
	}
	
	
	

}
