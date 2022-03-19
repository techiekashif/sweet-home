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

import com.google.common.collect.Lists;
import com.kashif.booking.dto.BookingRequestDTO;
import com.kashif.booking.dto.BookingResponseDTO;
import com.kashif.booking.dto.ErrorDTO;
import com.kashif.booking.dto.PaymentDTO;
import com.kashif.booking.entity.BookingInfoEntity;
import com.kashif.booking.service.BookingService;
import com.kashif.booking.utils.POJOConverter;

@RestController
@RequestMapping(value = "/hotel")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookingResponseDTO> saveBooking(@RequestBody BookingRequestDTO bookingDTO) {
		BookingInfoEntity booking = POJOConverter.convertBookingToEntity(bookingDTO);
		BookingInfoEntity savedUser = bookingService.createBooking(booking);
		if (savedUser != null) {
			BookingResponseDTO responseBookingDTO = POJOConverter.convertEntityToDTO(savedUser);
			return new ResponseEntity<BookingResponseDTO>(responseBookingDTO, HttpStatus.CREATED);
		}
		return null;
	}

	@PostMapping(value = "booking/{bookingId}/transaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getPaymentInfo(@RequestBody PaymentDTO paymentDTO, @PathVariable("bookingId") int bookingId) {
		if (!Lists.newArrayList("CARD", "UPI").contains(paymentDTO.getPaymentMode())) {
			return new ResponseEntity(new ErrorDTO("Invalid mode of payment", HttpStatus.BAD_REQUEST.value()),
					HttpStatus.BAD_REQUEST);
		}
		BookingInfoEntity bookingInfo = bookingService.getBookingDetails(bookingId);
		if (bookingInfo == null) {
			return new ResponseEntity(new ErrorDTO("Invalid booking id", HttpStatus.BAD_REQUEST.value()),
					HttpStatus.BAD_REQUEST);
		}
		BookingInfoEntity bookingInfoWithTransStatus = bookingService.getBookingDetails(bookingInfo, paymentDTO);
		System.out.println(bookingId);
		BookingResponseDTO bookingInfoResponse = POJOConverter.convertEntityToDTO(bookingInfoWithTransStatus);
		String message = "Booking confirmed for user with aadhaar number: " + bookingInfoResponse.getAdhaarNo()
				+ "    |    " + "Here are the booking details:    " + bookingInfoResponse.toString();
		System.out.println(message);
		return new ResponseEntity(bookingInfoResponse, HttpStatus.OK);
	}
}
