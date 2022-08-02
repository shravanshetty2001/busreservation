package com.lti.busreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.busreservation.models.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>{


}
