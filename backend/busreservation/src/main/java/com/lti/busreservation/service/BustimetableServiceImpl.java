package com.lti.busreservation.service;


	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.dto.Bustimtabledto;
import com.lti.busreservation.dto.Placedto;
import com.lti.busreservation.models.Bustimetable;
import com.lti.busreservation.repository.PlaceRepository;

@Service
public class BustimetableServiceImpl {
		
		@Autowired
		private PlaceRepository placerepository;
		
		public Bustimetable addBustimtetable( Bustimtabledto bustimtabledto, Placedto placedto) {
		
		
		Bustimetable bustimet = new Bustimetable();
		
		
		
		
		
		
		
		
		
		
		
		return bustimet;
		
		}
		
		
		
	
}
