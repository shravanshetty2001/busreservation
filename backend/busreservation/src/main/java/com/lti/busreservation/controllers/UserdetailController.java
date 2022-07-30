package com.lti.busreservation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.models.Userdetail;
import com.lti.busreservation.repository.UserdetailRepository;

@RestController
public class UserdetailController {

	@Autowired
	private UserdetailRepository userdetailRepository;
	@GetMapping("/userdetail")
	public List<Userdetail> getAllUserdetail(){
		
		return userdetailRepository.findAll();
	}
	
	@PostMapping("/userdetail")
	public Userdetail createUserdetail(@Valid @RequestBody Userdetail userdetail){
		
		return userdetailRepository.save(userdetail);
	}
	
	
	
	
}
