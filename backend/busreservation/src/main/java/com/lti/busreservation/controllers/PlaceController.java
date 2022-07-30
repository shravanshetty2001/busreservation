package com.lti.busreservation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.models.Place;
import com.lti.busreservation.repository.PlaceRepository;

@RestController
public class PlaceController {
	@Autowired
	private PlaceRepository placeRepository;
	
	@GetMapping("/place")
	public List<Place> getPlace()
	{
		return placeRepository.findAll();
	}
	
	@PostMapping("/place")
	public Place createPlace(@Valid @RequestBody Place pl)
	{
		return placeRepository.save(pl);
	}
}
