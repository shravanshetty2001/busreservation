package com.lti.busreservation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.dto.PaymentDto;
import com.lti.busreservation.dto.PaymentStatusDto;
import com.lti.busreservation.dto.PaymentinfoDto;
import com.lti.busreservation.services.PaymentService;

@CrossOrigin(origins="*")
@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	@GetMapping("/balance/{id}")
	public int findBalance(@PathVariable int id) {
		
		return paymentService.getBalance(id);
		
	}
	
	@PostMapping("/makePayment")
	public PaymentStatusDto makePayment(@Valid @RequestBody PaymentDto paymentDto) {
		
		return paymentService.doPayment(paymentDto);
	}
	
	@GetMapping("/getPayment")
	public List<PaymentinfoDto> getPayment(){
		return paymentService.getPayment();
	}
	
	
}
	
	

