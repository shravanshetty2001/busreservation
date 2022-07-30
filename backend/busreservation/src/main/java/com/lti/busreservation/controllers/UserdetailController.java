package com.lti.busreservation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.models.Userdetail;
import com.lti.busreservation.dto.UserdetailDto;
import com.lti.busreservation.services.UserdetailService;
import com.lti.busreservation.dto.*;

@RestController
@CrossOrigin("*")
public class UserdetailController {

	@Autowired
	private UserdetailService userdetailService;
	
	
	@GetMapping("/userdetail")
	public List<Userdetail> getAllUser(){
		
		return userdetailService.getAllUserdetail();
	}
	
	@PostMapping("/userdetail")
	public Userdetail createUserdetail(@Valid @RequestBody UserdetailDto userdetailDto){
		
		return userdetailService.addUserdetail(userdetailDto);
	}
	
	@PostMapping("/userlogin")
	public Userdetail verifyUserLogin(@Valid @RequestBody LoginDto loginDto){
		return userdetailService.verifyUser(loginDto);
	}
	
	
	@GetMapping("/name")
	public String getName(){
		return ("parth");
	}
	
	
	
	
	
}
