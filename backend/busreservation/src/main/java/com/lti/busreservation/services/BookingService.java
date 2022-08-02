package com.lti.busreservation.services;

import com.lti.busreservation.dto.BookingSeatDto;
import com.lti.busreservation.dto.TicketDto;


public interface BookingService {

	public TicketDto makeBooking(BookingSeatDto bookingSeatDto);
	public BookingSeatDto findBookingById(int id);
	public TicketDto authorizedUserMakeBooking(BookingSeatDto bookingSeatDto);
}
