package com.kashif.booking.service;

import com.kashif.booking.dto.PaymentDTO;
import com.kashif.booking.entity.BookingInfoEntity;

public interface BookingService {
	
	public BookingInfoEntity createBooking(BookingInfoEntity bookingInfo);
	
	public BookingInfoEntity getBookingDetails(int bookingId);

	public BookingInfoEntity getBookingDetails(BookingInfoEntity bookingInfo, PaymentDTO paymentDTO);

}
