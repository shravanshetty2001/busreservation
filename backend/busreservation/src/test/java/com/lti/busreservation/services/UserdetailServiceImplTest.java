package com.lti.busreservation.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.busreservation.dto.UserdetailDto;
import com.lti.busreservation.models.Buslist;
import com.lti.busreservation.models.Userdetail;
import com.lti.busreservation.repository.BuslistRepository;
import com.lti.busreservation.repository.UserdetailRepository;


class UserdetailServiceImplTest {

	
	@Autowired
	private UserdetailRepository userdetailRepository;
	
//	@Autowired
//	BuslistRepository buslistRepository;
	
	@Test
	void testVerifyUser() {
		List<Userdetail> userDetail= userdetailRepository.findAll();
		assertFalse(userDetail.isEmpty());
	}
}
