package com.lti.busreservation.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.dto.LoginDto;
import com.lti.busreservation.dto.UserdetailDto;
import com.lti.busreservation.dto.UserdetailRegisterDto;
import com.lti.busreservation.dto.UserdetailStatusDto;
import com.lti.busreservation.models.Userdetail;
import com.lti.busreservation.repository.UserdetailRepository;


@Service
public class UserdetailServiceImpl implements UserdetailService{
	
	@Autowired
	private UserdetailRepository userdetailRepository;
	
	
	@Override
	public UserdetailStatusDto verifyUser(LoginDto loginDto) {
		// TODO Auto-generated method stub
		
		List<Userdetail> ud=userdetailRepository.findAll();
		UserdetailStatusDto userdetailStatusDto=new UserdetailStatusDto();
		for(Userdetail u:ud) {
			
			if(u.getEmail().equalsIgnoreCase(loginDto.getEmail())) {
				
				if(u.getPassword().equals(loginDto.getPassword())) {
					
					userdetailStatusDto.setStatus(true);
					UserdetailDto userdetailDto=new UserdetailDto();
					userdetailDto.setId(u.getId());
					userdetailDto.setName(u.getName());
					userdetailDto.setEmail(u.getEmail());
					userdetailDto.setPassword(u.getPassword());
					userdetailDto.setContactNo(u.getPassword());
					userdetailDto.setContactNo(u.getContactNo());
					userdetailStatusDto.setUserdetailDto(userdetailDto);
					return userdetailStatusDto;
				}
				else {
					break;
				}
				
			}
			
			
		}
		userdetailStatusDto.setErrorMessge("Invalaid Email or Password");
		userdetailStatusDto.setStatus(false);
		return userdetailStatusDto;
	}


	@Override
	public List<UserdetailDto> getAllUserdetail() {
		// TODO Auto-generated method stub
		List<Userdetail> ud=userdetailRepository.findAll();
		List<UserdetailDto> userdetailDtos=new LinkedList<UserdetailDto>();
	
		for(Userdetail u:ud) {
			
			UserdetailDto userdetailDto=new UserdetailDto();
			userdetailDto.setId(u.getId());
			userdetailDto.setName(u.getName());
			userdetailDto.setEmail(u.getEmail());
			userdetailDto.setPassword(u.getPassword());
			userdetailDto.setContactNo(u.getPassword());
			userdetailDto.setContactNo(u.getContactNo());
			userdetailDtos.add(userdetailDto);
			
		}
		return userdetailDtos;
	}


	@Override
	public UserdetailStatusDto addUserdetail(UserdetailRegisterDto userdetailRegisterDto) {
		// TODO Auto-generated method stub
		List<Userdetail> ud=userdetailRepository.findAll();
		
		UserdetailStatusDto userdetailStatusDto=new UserdetailStatusDto();
		
		for(Userdetail u:ud) {
			
			if(u.getEmail().equalsIgnoreCase(userdetailRegisterDto.getEmail())) {
				userdetailStatusDto.setStatus(false);
				userdetailStatusDto.setErrorMessge("Email id already exists");
				return userdetailStatusDto;
			}
			
			
		}
		Userdetail userdetail=new Userdetail();
		userdetail.setName(userdetailRegisterDto.getName());
		userdetail.setContactNo(userdetailRegisterDto.getContactNo());
		userdetail.setEmail(userdetailRegisterDto.getEmail());
		userdetail.setPassword(userdetailRegisterDto.getPassword());
		Userdetail result;
		
		try {
			result = userdetailRepository.save(userdetail);
		}
		catch(Exception ex) {
			userdetailStatusDto.setStatus(false);
			userdetailStatusDto.setErrorMessge(ex.getMessage());
			return userdetailStatusDto;
		}
		
		UserdetailDto userdetailDto=new UserdetailDto();
		userdetailDto.setId(result.getId());
		userdetailDto.setName(result.getName());
		userdetailDto.setEmail(result.getEmail());
		userdetailDto.setPassword(result.getPassword());
		userdetailDto.setContactNo(result.getPassword());
		userdetailDto.setContactNo(result.getContactNo());
		userdetailStatusDto.setUserdetailDto(userdetailDto);
		userdetailStatusDto.setStatus(true);
		
		return userdetailStatusDto;
	}
	
	
	

}
