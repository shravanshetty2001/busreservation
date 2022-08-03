package com.lti.busreservation.services;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.busreservation.dto.BookingSeatDto;
import com.lti.busreservation.dto.TicketDto;
import com.lti.busreservation.models.Booking;
import com.lti.busreservation.models.Bustimetable;
import com.lti.busreservation.models.Payment;
import com.lti.busreservation.models.Unauthorizeduser;
import com.lti.busreservation.models.Userdetail;
import com.lti.busreservation.repository.BookingRepository;
import com.lti.busreservation.repository.BustimetableRepository;
import com.lti.busreservation.repository.PaymentRepository;
import com.lti.busreservation.repository.UnauthorizedUserRepository;
import com.lti.busreservation.repository.UserdetailRepository;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private UnauthorizedUserRepository unauthorizedUserRepository;
	
	@Autowired
	private BustimetableRepository bustimetableRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private UserdetailRepository userdetailRepository;
	
	@Override
	public TicketDto makeBooking(BookingSeatDto bookingSeatDto) {
		// TODO Auto-generated method stub

		Booking book = new Booking();
		Unauthorizeduser unauthorizeduser = new Unauthorizeduser();
		Bustimetable bustimetable = new Bustimetable();
		
		book.setBookingStatus("Confirmed");

		book.setSeatno(bookingSeatDto.getSeatno());
		
		Date date = new Date();
	    Timestamp timestamp = new Timestamp(date.getTime());
	    
	    Optional<Bustimetable> bustimetableEntity = bustimetableRepository.findById(bookingSeatDto.getBustimetable());
	    bustimetable = bustimetableEntity.get();
		
		
		book.setPayment(null);
		
		book.setBustimetable(bustimetable);

		bustimetable.getBooking().add(book);
				
		unauthorizeduser.setBooking(book);
		unauthorizeduser.setEmail(bookingSeatDto.getEmail());
		unauthorizeduser.setPhoneno(bookingSeatDto.getPhoneno());
		
		book.setUnauthorizeduser(unauthorizeduser);
		
		
		bookingRepository.save(book);
		bustimetableRepository.save(bustimetable);

		
		Unauthorizeduser result =unauthorizedUserRepository.save(unauthorizeduser);	
		
//		BookingSeatDto seatDto = new BookingSeatDto();
//		seatDto.setSeatno(result.getBooking().getSeatno());
//		seatDto.setEmail(result.getEmail());
//		seatDto.setPhoneno(result.getPhoneno());
//		seatDto.setBustimetable(0);
		
		TicketDto ticket = new TicketDto();
		ticket.setSeatno(result.getBooking().getSeatno());
		ticket.setRoute(bustimetable.getSourcePlace().getPlaceName()+" to "+bustimetable.getDesnPlace().getPlaceName());
		ticket.setSourceplace(bustimetable.getSourcePlace().getPlaceName());
		ticket.setDestplace(bustimetable.getDesnPlace().getPlaceName());
		ticket.setDate(bustimetable.getsDatetime());
		ticket.setTime(bustimetable.getsDatetime().getTime());
		ticket.setPhoneno(bookingSeatDto.getPhoneno());
		ticket.setName(bookingSeatDto.getUsername());
		ticket.setBookedOn(timestamp);
		ticket.setPrice(bustimetable.getPrice());

		return ticket;
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

	@Override
	public TicketDto authorizedUserMakeBooking(BookingSeatDto bookingSeatDto) {
		// TODO Auto-generated method stub
		
		Booking book = new Booking();
		Userdetail authorizeduser = new Userdetail();
		Payment payment = new Payment();
		
		book.setBookingStatus("Confirmed");

		book.setSeatno(bookingSeatDto.getSeatno());
		
		Date date = new Date();
	    Timestamp timestamp = new Timestamp(date.getTime());
		
		Optional<Userdetail> userEntity = userdetailRepository.findById(bookingSeatDto.getUserId());
		Userdetail user = userEntity.get();
		
		Optional<Bustimetable> bustimetableEntity = bustimetableRepository.findById(bookingSeatDto.getBustimetable());
		Bustimetable bustimetable = bustimetableEntity.get();
		
		payment.setAmount(bustimetable.getPrice());
		payment.setPaymentType(true);
		payment.setPaymentDatetime(timestamp);
		payment.setUserdetail(user);
		
		book.setPayment(payment);
		
		book.setBustimetable(bustimetable);

		book.setUnauthorizeduser(null);
		
		payment.setBooking(book);
		
		bustimetable.getBooking().add(book);
		
		user.getPayment().add(payment);
		
		bookingRepository.save(book);
		bustimetableRepository.save(bustimetable);
		userdetailRepository.save(user);
			
		
		TicketDto ticket = new TicketDto();
		ticket.setSeatno(bookingSeatDto.getSeatno());
		ticket.setRoute(bustimetable.getSourcePlace().getPlaceName()+" to "+bustimetable.getDesnPlace().getPlaceName());
		ticket.setSourceplace(bustimetable.getSourcePlace().getPlaceName());
		ticket.setDestplace(bustimetable.getDesnPlace().getPlaceName());
		ticket.setDate(bustimetable.getsDatetime());
		ticket.setTime(bustimetable.getsDatetime().getTime());
		ticket.setPhoneno(bookingSeatDto.getPhoneno());
		ticket.setName(bookingSeatDto.getUsername());
		ticket.setBookedOn(timestamp);
		ticket.setPrice(bustimetable.getPrice());

		return ticket;
		
	}
}
