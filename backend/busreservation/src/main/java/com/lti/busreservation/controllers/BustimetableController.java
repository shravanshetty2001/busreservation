package com.lti.busreservation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.dto.Bustimetabledto;
import com.lti.busreservation.models.Bustimetable;
import com.lti.busreservation.repository.BustimetableRepository;
import com.lti.busreservation.service.BustimetableService;

	@RestController
	@CrossOrigin("*")
	public class BustimetableController {
		@Autowired
		private BustimetableService bustimetableService;
		
		@GetMapping("/bustimetable")
		public List<Bustimetabledto> getBustimetable()
		{
			return bustimetableService.getAllbuslistdetail();
		}
		@PostMapping("/bustimetable")
		public Bustimetabledto createBustimetable(@Valid @RequestBody Bustimetabledto bs)
		{
			return bustimetableService.addbustimtable(bs);
		}
		
		@PostMapping("/getbustimetable")
		public List<Bustimetabledto> findBustimetable(@Valid @RequestBody Bustimetabledto bustimetabledto){
			return bustimetableService.getAllbuslistuser(bustimetabledto);
		}
		@PostMapping("/viewbustimetable")
		public List <Bustimetabledto> adminBudTimetable(@Valid @RequestBody int admin)
		{
			return bustimetableService.getAllbuslistadmin(admin);
		}
	}





