package com.kashif.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kashif.booking.entity.BookingInfoEntity;
import com.kashif.booking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public BookingInfoEntity createBooking(BookingInfoEntity bookingInfo) {
		return bookingRepository.save(bookingInfo);
	}
	

}
