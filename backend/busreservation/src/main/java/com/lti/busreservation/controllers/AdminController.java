package com.lti.busreservation.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.models.Admin;
import com.lti.busreservation.repository.AdminRepository;

@RestController
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;
	@GetMapping("/adminlogin")
	public List<Admin> getAdmin()
	{
		return adminRepository.findAll();
	}
	@PostMapping("/adminregister")
	public Admin createAdmin(@Valid @RequestBody Admin ad)
	{
		return adminRepository.save(ad);
	}

}
