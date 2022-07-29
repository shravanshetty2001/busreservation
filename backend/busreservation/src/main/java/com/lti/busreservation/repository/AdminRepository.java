package com.lti.busreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.busreservation.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
