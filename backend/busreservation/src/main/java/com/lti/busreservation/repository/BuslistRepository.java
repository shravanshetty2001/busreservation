package com.lti.busreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.busreservation.models.Buslist;

public interface BuslistRepository extends JpaRepository<Buslist, Long>{

	

}
