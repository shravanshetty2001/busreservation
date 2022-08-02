package com.lti.busreservation.services;

import java.util.List;

import com.lti.busreservation.dto.PaymentDto;
import com.lti.busreservation.dto.PaymentStatusDto;
import com.lti.busreservation.dto.PaymentinfoDto;

public interface PaymentService {
	public int getBalance(int id);
	public PaymentStatusDto doPayment(PaymentDto paymentDto);
	public List<PaymentinfoDto> getPayment();

}
