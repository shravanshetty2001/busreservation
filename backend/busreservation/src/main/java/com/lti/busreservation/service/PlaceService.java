package com.lti.busreservation.service;

import com.lti.busreservation.dto.Placedto;
import com.lti.busreservation.models.Place;

public interface PlaceService {
	
		public Place getPlace(Placedto placedto);

}
