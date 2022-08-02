package com.lti.busreservation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.dto.BookingSeatDto;
import com.lti.busreservation.models.Booking;
import com.lti.busreservation.models.Unauthorizeduser;
import com.lti.busreservation.repository.BookingRepository;
import com.lti.busreservation.repository.UnauthorizedUserRepository;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private UnauthorizedUserRepository unauthorizedUserRepository;
	
	@Override
	public BookingSeatDto makeBooking(BookingSeatDto bookingSeatDto) {
		// TODO Auto-generated method stub

		Booking book = new Booking();
		Unauthorizeduser unauthorizeduser = new Unauthorizeduser();
		
		book.setBookingStatus("Confirmed");

		book.setSeatno(bookingSeatDto.getSeatno());
		
		book.setPayment(null);
		
		book.setBustimetable(null);

		unauthorizeduser.setBooking(book);
		unauthorizeduser.setEmail(bookingSeatDto.getEmail());
		unauthorizeduser.setPhoneno(bookingSeatDto.getPhoneno());
		
		book.setUnauthorizeduser(unauthorizeduser);
		
		
		bookingRepository.save(book);
		Unauthorizeduser result =unauthorizedUserRepository.save(unauthorizeduser);		
		
		BookingSeatDto seatDto = new BookingSeatDto();
		seatDto.setSeatno(result.getBooking().getSeatno());
		seatDto.setEmail(result.getEmail());
		seatDto.setPhoneno(result.getPhoneno());
		seatDto.setBustimetable(0);
//		seatDto.setUserId(unauthorizeduser.getId());
		
		return seatDto;
	}

	@Override
	public BookingSeatDto findBookingById(int id) {
		Unauthorizeduser unauthorizeduser = new Unauthorizeduser();
		Optional<Unauthorizeduser> UnauthorizeduserEntity = unauthorizedUserRepository.findById(id);
		unauthorizeduser = UnauthorizeduserEntity.get();
		
		BookingSeatDto seatDto = new BookingSeatDto();
		seatDto.setSeatno(unauthorizeduser.getBooking().getSeatno());
		seatDto.setEmail(unauthorizeduser.getEmail());
		seatDto.setPhoneno(unauthorizeduser.getPhoneno());
		seatDto.setBustimetable(0);
//		seatDto.setUserId(unauthorizeduser.getId());
		return seatDto;
	}

}
