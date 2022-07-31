package com.lti.busreservation.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.busreservation.dto.BookingSeatDto;
import com.lti.busreservation.service.BookingService;


@RestController
@CrossOrigin(origins = "*")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("bookings/{id}")
	public BookingSeatDto Bookings(@PathVariable int id)
	{
		return bookingService.findBookingById(id);
	}
	
	@PostMapping("bookings/unauthorizedUser/makebooking")
	public BookingSeatDto makeUnauthorizedUserBooking(@Valid @RequestBody BookingSeatDto bookingSeatDto)
	{
		return bookingService.makeBooking(bookingSeatDto);
	}

}
