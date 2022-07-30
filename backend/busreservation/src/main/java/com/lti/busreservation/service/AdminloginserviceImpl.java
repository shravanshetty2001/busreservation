package com.lti.busreservation.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.models.Admin;
import com.lti.busreservation.repository.AdminRepository;

@Service
public class AdminloginserviceImpl implements Adminloginservice {
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public boolean verifyData(String email,String password)
	{
		List<Admin> ad=adminRepository.findAll();
		for(Admin a:ad)
		{
			if(a.getEmail().equals(email))
			{
				if(a.getPassword().equals(password))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;	
	}
	@Override
	public boolean registerData(Admin ad)
	{
		List<Admin> adm=adminRepository.findAll();
		for(Admin a:adm)
		{
			if(a.getEmail().equals(ad.getEmail()))
			{
				return false;
			}
		}
		adminRepository.save(ad);
		return true;
	}
}