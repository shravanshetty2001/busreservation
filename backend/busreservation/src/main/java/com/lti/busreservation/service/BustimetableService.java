package com.lti.busreservation.service;

import com.lti.busreservation.dto.Buslistdto;
import com.lti.busreservation.dto.Bustimtabledto;
import com.lti.busreservation.models.Bustimetable;

public interface BustimetableService  {
	public Bustimetable bustimetable(Bustimtabledto bustimtabledto);
	public Bustimetable getBustimetable();
	
}
