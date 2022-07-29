package com.lti.busreservation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.models.Payment;
import com.lti.busreservation.repository.PaymentRepository;


@RestController
public class PaymentController {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	@GetMapping("/payment")
	public List<Payment> getAllUserdetail(){
		
		return paymentRepository.findAll();
	}
	
	@PostMapping("/payment")
	public Payment createUserdetail(@Valid @RequestBody Payment payment){
		
		return paymentRepository.save(payment);
	}
	
	
}
