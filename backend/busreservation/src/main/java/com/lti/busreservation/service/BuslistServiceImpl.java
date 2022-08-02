package com.lti.busreservation.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.dto.Buslistdto;
import com.lti.busreservation.dto.Bustimetabledto;
import com.lti.busreservation.dto.UserdetailDto;
import com.lti.busreservation.dto.UserdetailRegisterDto;
import com.lti.busreservation.models.Admin;
import com.lti.busreservation.models.Buslist;
import com.lti.busreservation.models.Userdetail;
import com.lti.busreservation.repository.AdminRepository;
import com.lti.busreservation.repository.BuslistRepository;
import com.lti.busreservation.repository.BustimetableRepository;

@Service
public class BuslistServiceImpl implements BuslistService {
	
	@Autowired
	private BustimetableRepository bustimetablerepository;
	
	@Autowired
	private BuslistRepository buslistrepository;
	
	@Autowired 
	private AdminRepository adminRepository;
	
	

	
	@Override
	public List<Buslistdto> getAllbusdetail() {
		// TODO Auto-generated method stub
		
		
			List<Buslist> bl= buslistrepository.findAll();
			List<Buslistdto> buslistdtos=new LinkedList<Buslistdto>();
		
			for(Buslist b : bl) {
				
				Buslistdto buslistdto=new Buslistdto();
				buslistdto.setId(b.getId());
				buslistdto.setBusType(b.getBusType());
				buslistdto.setNoSeats(b.getNoSeats());
				buslistdto.setBusNo(b.getBusNo());
				buslistdto.setSleeper(b.isSleeper());
				buslistdto.setAc(b.isAc());
				buslistdto.setAdmin(b.getAdmin().getId());				
				buslistdtos.add(buslistdto);
				
			}
			return buslistdtos;
		

	
	}

	
	@Override
	public Buslistdto addbusdetail(Buslistdto buslistdto) {
		// TODO Auto-generated method stub
		
		Buslist bus = new Buslist();
		

		
		bus.setBusType(buslistdto.getBusType());
        bus.setNoSeats(38);
        bus.setBusNo(buslistdto.getBusNo());
        bus.setSleeper(buslistdto.getSleeper());
        bus.setAc(buslistdto.getAc());
    	Optional<Admin> AdminEntity = adminRepository.findById(buslistdto.getAdmin());
		Admin adm = AdminEntity.get();
        bus.setAdmin(adm);
        adm.getBuslist().add(bus);
        buslistrepository.save(bus);
        buslistdto.setId(bus.getId());
		return buslistdto;
	}


	@Override
	public List<Buslistdto> getAdminbus(int adminid) {
		Optional<Admin> adminEntity = adminRepository.findById(adminid);
        Admin ad = adminEntity.get();
        List<Buslist> buslist=ad.getBuslist();
        List<Buslistdto> bdto=new LinkedList<>();
        for(Buslist b: buslist)
        {
        	Buslistdto bd=new Buslistdto();
        	bd.setId(b.getId());
        	bd.setBusType(b.getBusType());
        	bd.setBusNo(b.getBusNo());
        	bd.setAc(b.isAc());
        	bd.setSleeper(b.isSleeper());
        	bdto.add(bd);      	
        }
        return bdto;
        
		
	}
	
	
	
}

