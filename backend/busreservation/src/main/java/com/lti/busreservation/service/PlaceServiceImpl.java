package com.lti.busreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.dto.Placedto;
import com.lti.busreservation.models.Place;
import com.lti.busreservation.repository.BustimetableRepository;

@Service
public class PlaceServiceImpl implements PlaceService{

	@Autowired
	private BustimetableRepository bustimetablerepository;
	
	@Override
	public Place getPlace(Placedto placedto) {
		// TODO Auto-generated method stub
		
		
		Place pl = new Place();
		
		
		pl.setPlaceName(placedto.getPlaceName());
		
		
		
		return pl;
	}
	
	
	
	
}
