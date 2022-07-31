package com.lti.busreservation.service;

import com.lti.busreservation.dto.BookingSeatDto;


public interface BookingService {

	public BookingSeatDto makeBooking(BookingSeatDto bookingSeatDto);
	public BookingSeatDto findBookingById(int id);

}
