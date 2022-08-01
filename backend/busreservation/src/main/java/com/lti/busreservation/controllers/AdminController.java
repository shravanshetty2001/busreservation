package com.lti.busreservation.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.dto.AdminDto;
import com.lti.busreservation.dto.AdminloginDto;
import com.lti.busreservation.dto.AdminregisterDto;
import com.lti.busreservation.dto.AdminstatusDto;
import com.lti.busreservation.dto.ForgotPasswordDto;
import com.lti.busreservation.dto.UpdatePasswordDto;
import com.lti.busreservation.models.Admin;
import com.lti.busreservation.service.Adminloginservice;
import com.lti.busreservation.status.Status;


@RestController
@CrossOrigin(origins="*")
public class AdminController {
	@Autowired
	private Adminloginservice adminService;
	//private AdminRepository adminRepository;

	
	@PostMapping("/admin/register")
	public AdminstatusDto createAdmin(@Valid @RequestBody AdminregisterDto adminregisterDto)
	{
		
		return adminService.registerData(adminregisterDto);
	}
	@PostMapping("/admin/verify")
	public  AdminstatusDto verifyUser(@Valid @RequestBody AdminloginDto adminloginDto){
		
		return adminService.verifyData(adminloginDto);
		
    }
	@PostMapping("admin/forgotpassword")
	public AdminstatusDto forgotPassword(@Valid @RequestBody ForgotPasswordDto forgotPasswordDto)
	{
		return adminService.forgotPassword(forgotPasswordDto);
	}
	
	@PostMapping("/resetpassword/{id}")
	public AdminstatusDto updatePassword(@PathVariable("id") int id,@Valid @RequestBody UpdatePasswordDto updatePasswordDto )
	{
		return adminService.updatePassword(id,updatePasswordDto);
	}

}