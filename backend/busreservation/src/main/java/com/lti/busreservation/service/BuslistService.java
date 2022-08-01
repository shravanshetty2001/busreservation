package com.lti.busreservation.service;

import com.lti.busreservation.dto.Buslistdto;
import com.lti.busreservation.dto.Bustimtabledto;
import com.lti.busreservation.models.Buslist;

public interface BuslistService {
	public Buslist addBuslist(Buslistdto Buslistdto,Bustimtabledto bustimtabledto);
	public Buslist getBuslist();
	
}
