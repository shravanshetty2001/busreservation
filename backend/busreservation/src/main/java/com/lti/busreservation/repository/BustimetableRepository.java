package com.lti.busreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.busreservation.models.Bustimetable;

public interface BustimetableRepository extends JpaRepository<Bustimetable, Long> {

}