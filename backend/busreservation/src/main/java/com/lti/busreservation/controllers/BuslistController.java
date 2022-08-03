package com.lti.busreservation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.dto.Buslistdto;
import com.lti.busreservation.dto.ViewDto;
import com.lti.busreservation.models.Buslist;
import com.lti.busreservation.repository.BuslistRepository;
import com.lti.busreservation.service.BuslistService;

@RestController
@CrossOrigin(origins="*")
public class BuslistController {
	@Autowired
	private BuslistService buslistService;
	
	@GetMapping("/Buslist")
	public List<Buslistdto> getBuslist()
	{
		return buslistService.getAllbusdetail();
	}
	
	 @PostMapping("/Buslist")
	  public Buslistdto createBuslist(@Valid @RequestBody Buslistdto bs)
	  {
	      return buslistService.addbusdetail(bs);
	  }
	 
	 @PostMapping("/viewbus")
	 public List<Buslistdto> getAdminbuslist(@Valid @RequestBody int viewDto)
	 {
		 return buslistService.getAdminbus(viewDto);
	 }
	
}

