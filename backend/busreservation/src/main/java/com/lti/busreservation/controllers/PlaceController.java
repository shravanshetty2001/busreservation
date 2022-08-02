package com.lti.busreservation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.dto.Placedto;
import com.lti.busreservation.models.Place;
import com.lti.busreservation.repository.PlaceRepository;
import com.lti.busreservation.services.PlaceService;

@RestController
@CrossOrigin("*")
public class PlaceController {
	@Autowired
	private PlaceService placeService;
	
	
	@GetMapping("/getplaces")
	public List<Placedto> getPlace()
	{
		return placeService.getPlace();
	}
	
	@PostMapping("/addplace")
	public boolean createPlace(@Valid @RequestBody Placedto placedto)
	{
		return placeService.addPlace(placedto);
	}
}
