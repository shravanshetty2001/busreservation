package com.lti.busreservation.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.dto.UnauthorizedUserDto;
import com.lti.busreservation.models.Unauthorizeduser;
import com.lti.busreservation.repository.UnauthorizedUserRepository;
import com.lti.busreservation.service.UnauthorizedUserService;

@RestController
@CrossOrigin(origins = "*")
public class UnauthorizedUserController {

	@Autowired
	private UnauthorizedUserRepository unauthorizedUserRepository;
	
	@Autowired
	private UnauthorizedUserService unauthorizedUserService;
	
	@GetMapping("/unauthorizeduser/{id}")
	public UnauthorizedUserDto getunauthorizedUser(@PathVariable int id)
	{
		return unauthorizedUserService.getUnauthorizeduser(id);
	}
	
	@PostMapping("/unauthorizeduser/store")
	public boolean addunauthorizedUser(@Valid @RequestBody UnauthorizedUserDto unaudto)
	{
		return unauthorizedUserService.addUnauthorizedUser(unaudto);
	}

}
