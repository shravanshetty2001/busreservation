package com.lti.busreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.busreservation.models.Payment;


public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}
