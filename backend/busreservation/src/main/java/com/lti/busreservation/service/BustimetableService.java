package com.lti.busreservation.service;

import java.util.List;

import com.lti.busreservation.dto.Buslistdto;
import com.lti.busreservation.dto.Bustimetabledto;

public interface BustimetableService  {
	
	
	
	
	
	
	List<Bustimetabledto> getAllbuslistuser(Bustimetabledto bustimetabledto);

	Bustimetabledto addbustimtable(Bustimetabledto bustimetabledto);

	List<Bustimetabledto> getAllbuslistdetail();

	List<Bustimetabledto> getAllbuslistadmin(int admin);
	
}
