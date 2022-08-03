package com.lti.busreservation.service;

import java.util.List;

import javax.validation.Valid;

import com.lti.busreservation.dto.Buslistdto;
import com.lti.busreservation.dto.Bustimetabledto;
import com.lti.busreservation.dto.UserdetailDto;
import com.lti.busreservation.dto.UserdetailRegisterDto;
import com.lti.busreservation.dto.UserdetailStatusDto;
import com.lti.busreservation.dto.ViewDto;
import com.lti.busreservation.models.Buslist;

public interface BuslistService {
	
	List<Buslistdto> getAllbusdetail();
	

	Buslistdto addbusdetail(Buslistdto buslistdto);





	List<Buslistdto> getAdminbus(int viewDto);
	
}

