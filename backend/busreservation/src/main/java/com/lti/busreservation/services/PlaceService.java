package com.lti.busreservation.services;

import java.util.List;

import com.lti.busreservation.dto.Placedto;
import com.lti.busreservation.models.Place;

public interface PlaceService {
	
		public List<Placedto> getPlace();
		public boolean addPlace(Placedto p);

}
