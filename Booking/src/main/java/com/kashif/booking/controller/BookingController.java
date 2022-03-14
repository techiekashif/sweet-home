package com.kashif.booking.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kashif.booking.dto.BookingDTO;
import com.kashif.booking.entity.BookingInfoEntity;
import com.kashif.booking.service.BookingService;

@RestController
@RequestMapping(value = "/payment/v1")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping(value = "/addBooking" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookingDTO> saveBooking(@RequestBody BookingDTO bookingDTO){
		BookingInfoEntity booking = modelMapper.map(bookingDTO, BookingInfoEntity.class);
		BookingInfoEntity savedUser = bookingService.createBooking(booking);
		if(savedUser !=null) {
			BookingDTO responseBookingDTO = modelMapper.map(savedUser, BookingDTO.class);
			return new ResponseEntity<BookingDTO>(responseBookingDTO , HttpStatus.CREATED);
		}
		return null;
	}

}
