package com.lti.busreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.dto.Buslistdto;
import com.lti.busreservation.dto.Bustimtabledto;
import com.lti.busreservation.models.Buslist;
import com.lti.busreservation.repository.BustimetableRepository;

@Service
public class BuslistServiceImpl implements BuslistService {
	
	@Autowired
	private BustimetableRepository bustimetablerepository;
	
	@Override
	public Buslist addBuslist(Buslistdto buslistdto, Bustimtabledto bustimtabledto) {
	
	
	Buslist busl = new Buslist();
	
	
	
	
	busl.setNoSeats(buslistdto.getNoSeats());
	busl.setBusType(buslistdto.getBusType());
	busl.setBusNo(buslistdto.getBusNo());
	busl.setSleeper(buslistdto.getSleeper());
	busl.setAc(buslistdto.getAc());
	
	
	
	
	
	return busl;
	
	}

	@Override
	public Buslist getBuslist() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
