package com.lti.busreservation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.models.Buslist;
import com.lti.busreservation.repository.BuslistRepository;

@RestController
public class BuslistController {
	@Autowired
	private BuslistRepository buslistRepository;
	
	@GetMapping("/Buslist")
	public List<Buslist> getBuslist()
	{
		return buslistRepository.findAll();
	}
	
	 @PostMapping("/Buslist")
	  public Buslist createBuslist(@Valid @RequestBody Buslist bs)
	  {
	      return buslistRepository.save(bs);
	  }
	
}
