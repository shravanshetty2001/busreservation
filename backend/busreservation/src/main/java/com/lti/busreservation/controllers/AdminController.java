package com.lti.busreservation.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.dto.AdminloginDto;
import com.lti.busreservation.dto.AdminregisterDto;
import com.lti.busreservation.models.Admin;
import com.lti.busreservation.service.Adminloginservice;


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
	public boolean createAdmin(@Valid @RequestBody AdminregisterDto adminregisterDto)
	{
		Admin ad=new Admin();
		ad.setEmail(adminregisterDto.getEmail());
		ad.setPassword(adminregisterDto.getPassword());
		ad.setTravelname(adminregisterDto.getTravelname());
		ad.setContactno(adminregisterDto.getContactno());
		boolean k=adminService.registerData(ad);	
		return k;
	}
	@PostMapping("/admin/verify")
	public boolean verifyUser(@Valid @RequestBody AdminloginDto adminloginDto){
        boolean k=adminService.verifyData(adminloginDto.getEmail(),adminloginDto.getPassword());
        return k;
    }

}