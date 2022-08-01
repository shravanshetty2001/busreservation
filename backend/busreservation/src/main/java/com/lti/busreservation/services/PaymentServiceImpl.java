package com.lti.busreservation.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.dto.PaymentDto;
import com.lti.busreservation.dto.PaymentStatusDto;
import com.lti.busreservation.dto.PaymentinfoDto;
import com.lti.busreservation.models.Payment;
import com.lti.busreservation.models.Userdetail;
import com.lti.busreservation.repository.PaymentRepository;
import com.lti.busreservation.repository.UserdetailRepository;




@Service
public class PaymentServiceImpl implements PaymentService{
	
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private UserdetailRepository userdetailRepository;

	@Override
	public int getBalance(int id) {
		// TODO Auto-generated method stub
		int amount=0;
		Optional<Userdetail> userdetailResponse=userdetailRepository.findById(id);
		Userdetail userdetail=userdetailResponse.get();
		List<Payment> userPaymentList=userdetail.getPayment();
		
		
		for(Payment p:userPaymentList) {
			if(p.isPaymentType()==true) {
				amount=(int) (amount+p.getAmount());
			}
			else {
				amount=(int) (amount-p.getAmount());
			}
		}
		
		return amount;
	}

	@Override
	public PaymentStatusDto doPayment(PaymentDto paymentDto) {
		// TODO Auto-generated method stub
		PaymentStatusDto paymentStatusDto=new PaymentStatusDto();
		Payment payment=new Payment();
		if(paymentDto.isType()==true) {
			payment.setAmount(paymentDto.getAmount());
			payment.setPaymentDatetime(null);
			payment.setPaymentType(paymentDto.isType());
			Optional<Userdetail> userdetailResponse=userdetailRepository.findById(paymentDto.getUserId());
			Userdetail userdetail=userdetailResponse.get();
			payment.setUserdetail(userdetail);
			Payment paymentResult=paymentRepository.save(payment);
			userdetail.getPayment().add(paymentResult);
			userdetailRepository.save(userdetail);
			paymentStatusDto.setStatus(true);
			paymentStatusDto.setErrMessage("Transaction successfull");
			
		}
		
		
		
		
		return paymentStatusDto;
	}

	@Override
	public List<PaymentinfoDto> getPayment() {
		// TODO Auto-generated method stub
		List<Payment> payments=paymentRepository.findAll();
		List<PaymentinfoDto> paymentinfoDtos=new LinkedList<>();
		
		for(Payment p:payments) {
			
			PaymentinfoDto paymentinfoDto=new PaymentinfoDto();
			paymentinfoDto.setId(p.getId());
			paymentinfoDto.setAmount(p.getAmount());
			paymentinfoDto.setBookingId(0);
			paymentinfoDto.setPaymentDatetime(p.getPaymentDatetime());
			paymentinfoDto.setUserId(p.getUserdetail().getId());
			
			paymentinfoDtos.add(paymentinfoDto);
			
		}
		
		
		return paymentinfoDtos;
	}

}
