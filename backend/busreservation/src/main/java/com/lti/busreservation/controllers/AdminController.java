package com.lti.busreservation.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.dto.AdminDto;
import com.lti.busreservation.dto.AdminloginDto;
import com.lti.busreservation.dto.AdminregisterDto;
import com.lti.busreservation.dto.AdminstatusDto;
import com.lti.busreservation.models.Admin;
import com.lti.busreservation.service.Adminloginservice;
import com.lti.busreservation.status.Status;


@RestController
@CrossOrigin(origins="*")
public class AdminController {
	@Autowired
	private Adminloginservice adminService;
	//private AdminRepository adminRepository;
	@GetMapping("/admin/login")
	public boolean getAdmin()
	{
		return true;
	}
	
	@PostMapping("/admin/register")
	public AdminstatusDto createAdmin(@Valid @RequestBody AdminregisterDto adminregisterDto)
	{
		
		return adminService.registerData(adminregisterDto);
	}
	@PostMapping("/admin/verify")
	public  AdminstatusDto verifyUser(@Valid @RequestBody AdminloginDto adminloginDto){
		
		return adminService.verifyData(adminloginDto);
		
    }

}