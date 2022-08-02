package com.lti.busreservation.service;


	import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.controllers.PlaceController;
import com.lti.busreservation.dto.Buslistdto;
import com.lti.busreservation.dto.Bustimetabledto;
import com.lti.busreservation.dto.Placedto;
import com.lti.busreservation.dto.UserdetailRegisterDto;
import com.lti.busreservation.dto.UserdetailStatusDto;
import com.lti.busreservation.models.Admin;
import com.lti.busreservation.models.Buslist;
import com.lti.busreservation.models.Bustimetable;
import com.lti.busreservation.models.Place;
import com.lti.busreservation.models.Userdetail;
import com.lti.busreservation.repository.AdminRepository;
import com.lti.busreservation.repository.BuslistRepository;
import com.lti.busreservation.repository.BustimetableRepository;
import com.lti.busreservation.repository.PlaceRepository;

@Service
public class BustimetableServiceImpl implements BustimetableService {
		
		@Autowired
		private PlaceRepository placerepository;
		
		@Autowired
		private BuslistRepository buslistrepository;
		
		
		@Autowired
		private BustimetableRepository bustimetableRepository;
		

		
		

		
		

		@Override
		public List<Bustimetabledto> getAllbuslistdetail() {
			// TODO Auto-generated method stub
			
			List<Bustimetable> bustimetables =bustimetableRepository.findAll();
			List<Bustimetabledto> bustimetabledtos= new ArrayList<>();
			
			for(Bustimetable b : bustimetables) {
									
					
						
						
							Bustimetabledto bt = new Bustimetabledto();
							bt.setBlid(b.getId());
							bt.setsDatetime(b.getsDatetime());
							bt.setdDatetime(b.getdDatetime());
							bt.setSourcePlace(b.getSourcePlace().getPlaceName());
							bt.setDesnPlace(b.getDesnPlace().getPlaceName());
							bt.setSourceplaceid(b.getSourcePlace().getId());
							bt.setDesnplaceid(b.getDesnPlace().getId());
							
							bustimetabledtos.add(bt);
							
						}
				
			return bustimetabledtos;
			
			
		}
		
		@Override
		public Bustimetabledto addbustimtable(Bustimetabledto bustimetabledto) {
			// TODO Auto-generated method stub
			
			Bustimetable bust = new Bustimetable();
			
			
			
			Optional<Place> srcplaceEntity = placerepository.findById(bustimetabledto.getSourceplaceid());
			Place srcplace = srcplaceEntity.get();
			bust.setSourcePlace(srcplace);
			
			Optional<Place> destplaceEntity = placerepository.findById(bustimetabledto.getDesnplaceid());
			Place desnplace = destplaceEntity.get();
			
			bust.setDesnPlace(desnplace);
			
			bust.setsDatetime(bustimetabledto.getsDatetime());
			bust.setdDatetime(bustimetabledto.getdDatetime());
			
			
			
			bustimetableRepository.save(bust);
            
            Bustimetabledto bustimetabledto2 = new Bustimetabledto();
            
            bustimetabledto2.setBlid(bust.getId());
            bustimetabledto2.setdDatetime(bust.getdDatetime());
            bustimetabledto2.setsDatetime(bust.getsDatetime());
            bustimetabledto2.setSourcePlace(srcplace.getPlaceName());
            bustimetabledto2.setDesnPlace(desnplace.getPlaceName());
            bustimetabledto2.setSourceplaceid(srcplace.getId());
            bustimetabledto2.setDesnplaceid(desnplace.getId());
            
            
            
			return bustimetabledto2;
            
	}

		@Override
		public List<Bustimetabledto> getAllbuslistuser(Bustimetabledto bustimetabledto) {
			// TODO Auto-generated method stub
			
			List<Bustimetable> bustimetables =bustimetableRepository.findAll();
			List<Bustimetabledto> bustimetabledtos= new ArrayList<>();
			
			for(Bustimetable b : bustimetables) {
				if(b.getSourcePlace().getPlaceName().equals(bustimetabledto.getSourcePlace())){
					
					if(b.getDesnPlace().getPlaceName().equals(bustimetabledto.getDesnPlace())) {
						Date date = new Date(b.getsDatetime().getTime());
						
						Date date1 = new Date(b.getdDatetime().getTime());
						if(date1.equals(date)) {
							Bustimetabledto bt = new Bustimetabledto();
							bt.setBlid(b.getId());
							bt.setsDatetime(b.getsDatetime());
							bt.setdDatetime(b.getdDatetime());
							bt.setSourcePlace(b.getSourcePlace().getPlaceName());
							bt.setDesnPlace(b.getDesnPlace().getPlaceName());
							bt.setSourceplaceid(b.getSourcePlace().getId());
							bt.setDesnplaceid(b.getDesnPlace().getId());
							
							bustimetabledtos.add(bt);
							
						}
					}
				}
			}
			
			
			return bustimetabledtos;
		}
		
	
	
		
		
	
}

