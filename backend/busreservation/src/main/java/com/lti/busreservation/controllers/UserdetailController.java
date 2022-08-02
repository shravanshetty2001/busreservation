package com.lti.busreservation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.dto.UserdetailRegisterDto;
import com.lti.busreservation.services.UserdetailService;
import com.lti.busreservation.dto.*;

@RestController
@CrossOrigin(origins="*")
public class UserdetailController {

	@Autowired
	private UserdetailService userdetailService;
	
	
	@GetMapping("/userdetail")
	public List<UserdetailDto> getAllUser(){
		
		return userdetailService.getAllUserdetail();
	}
	
	@PostMapping("/userdetail")
	public UserdetailStatusDto createUserdetail(@Valid @RequestBody UserdetailRegisterDto userdetailRegisterDto){
		
		return userdetailService.addUserdetail(userdetailRegisterDto);
	}
	
	@PostMapping("/userlogin")
	public UserdetailStatusDto verifyUserLogin(@Valid @RequestBody LoginDto loginDto){
		return userdetailService.verifyUser(loginDto);
	}
	
	
	@GetMapping("/name")
	public String getName(){
		return ("parth");
	}
	
	
	
	
	
}
