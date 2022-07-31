package com.lti.busreservation.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.dto.AdminDto;
import com.lti.busreservation.dto.AdminloginDto;
import com.lti.busreservation.dto.AdminregisterDto;
import com.lti.busreservation.dto.AdminstatusDto;
import com.lti.busreservation.models.Admin;
import com.lti.busreservation.repository.AdminRepository;

@Service
public class AdminloginserviceImpl implements Adminloginservice {
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public AdminstatusDto verifyData(AdminloginDto adminlogindto)
	{
		List<Admin> ad=adminRepository.findAll();
		AdminstatusDto asd=new AdminstatusDto();
		for(Admin a:ad)
		{
			if(a.getEmail().equals(adminlogindto.getEmail()))
			{

				if(a.getPassword().equals(adminlogindto.getPassword()))
				{
					AdminDto as=new AdminDto();
					as.setId(a.getId());
					as.setEmail(a.getEmail());
					as.setPassword(a.getPassword());
					as.setContactno(a.getContactno());
					as.setTravelname(a.getTravelname());
					asd.setStatus(true);
					asd.setAdmin(as);
					return asd;
				}
				else
				{
					asd.setStatus(false);
					asd.setErrorMessage("Wrong Password");
					return asd;
				}	
			}
	
		}
		asd.setStatus(false);
		asd.setErrorMessage("Email Not Present");
		return asd;
	}
	@Override
	public AdminstatusDto registerData(AdminregisterDto adminregisterDto)
	{
		AdminstatusDto asd=new AdminstatusDto();
		Admin ad=new Admin();
		int flag=0;
		Admin a;
		List<Admin> ar=adminRepository.findAll();
		for(Admin k:ar)
		{
			if(k.getEmail().equals(adminregisterDto.getEmail()))
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			asd.setStatus(false);
			asd.setErrorMessage("Email Already Exists");
			return asd;
		}
		try
		{
		ad.setEmail(adminregisterDto.getEmail());
		ad.setPassword(adminregisterDto.getPassword());
		ad.setTravelname(adminregisterDto.getTravelname());
		ad.setContactno(adminregisterDto.getContactno());
		a=adminRepository.save(ad);
		}
		catch(Exception e)
		{
			asd.setStatus(false);
			asd.setErrorMessage(e.getMessage());
			return asd;
		}

		AdminDto as=new AdminDto();
		as.setId(a.getId());
		as.setEmail(a.getEmail());
		as.setPassword(a.getPassword());
		as.setContactno(a.getContactno());
		as.setTravelname(a.getTravelname());
		asd.setStatus(true);
		asd.setAdmin(as);
		return asd;
	}
}