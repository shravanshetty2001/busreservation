package com.lti.busreservation.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.dto.Placedto;
import com.lti.busreservation.models.Place;
import com.lti.busreservation.repository.BustimetableRepository;
import com.lti.busreservation.repository.PlaceRepository;

@Service
public class PlaceServiceImpl implements PlaceService{

	@Autowired
	private BustimetableRepository bustimetablerepository;
	
	@Autowired
	private PlaceRepository placeRepository;
	
	@Override
	public List<Placedto> getPlace() {
		// TODO Auto-generated method stub
		
		
		List<Place> places = placeRepository.findAll();
		
		List<Placedto> placedtolist = new ArrayList<>();
		
		for(Place p: places) 
		{
			Placedto placedto = new Placedto();
			placedto.setPid(p.getId());
			placedto.setPlaceName(p.getPlaceName());
			
			placedtolist.add(placedto);
		}
		
		
		
		return placedtolist;
	}

	@Override
	public boolean addPlace(Placedto p) {
		// TODO Auto-generated method stub
		
		Place place = new Place();
		place.setPlaceName(p.getPlaceName());
		placeRepository.save(place);
		
		return true;
	}
	
	
	
	
}
