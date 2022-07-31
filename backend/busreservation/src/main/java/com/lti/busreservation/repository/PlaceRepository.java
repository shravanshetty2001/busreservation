package com.lti.busreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.busreservation.models.Place;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

	

}
