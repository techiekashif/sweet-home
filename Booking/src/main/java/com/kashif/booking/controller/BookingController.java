package com.kashif.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kashif.booking.dto.BookingRequestDTO;
import com.kashif.booking.dto.BookingResponseDTO;
import com.kashif.booking.dto.PaymentDTO;
import com.kashif.booking.entity.BookingInfoEntity;
import com.kashif.booking.service.BookingService;
import com.kashif.booking.utils.POJOConverter;

@RestController
@RequestMapping(value = "/hotel/")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookingResponseDTO> saveBooking(@RequestBody BookingRequestDTO bookingDTO){
		BookingInfoEntity booking = POJOConverter.convertBookingToEntity(bookingDTO);
		BookingInfoEntity savedUser = bookingService.createBooking(booking);
		if(savedUser !=null) {
			BookingResponseDTO responseBookingDTO = POJOConverter.convertEntityToDTO(savedUser);
			return new ResponseEntity<BookingResponseDTO>(responseBookingDTO , HttpStatus.CREATED);
		}
		return null;
	}
	
	@PostMapping(value = "booking/{bookingId}/transaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentDTO> getPaymentInfo(@RequestBody PaymentDTO paymentDTO, @PathVariable("bookingId") int bookingId){
		System.out.println(bookingId);
		return null;
		
		
	}

}
