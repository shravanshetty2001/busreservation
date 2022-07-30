package com.lti.busreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.busreservation.models.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
