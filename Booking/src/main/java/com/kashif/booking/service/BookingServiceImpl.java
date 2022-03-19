package com.kashif.booking.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kashif.booking.dto.PaymentDTO;
import com.kashif.booking.entity.BookingInfoEntity;
import com.kashif.booking.entity.RoomInfoEntity;
import com.kashif.booking.repository.BookingRepository;
import com.kashif.booking.repository.RoomRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${payment.transaction.endpoint}")
	private String url;

	@Override
	public BookingInfoEntity createBooking(BookingInfoEntity bookingInfo) {
		populateRoomParameters(bookingInfo);
		BookingInfoEntity bookingInfoEntity = bookingRepository.save(bookingInfo);
		return bookingInfoEntity;
	}

	private void populateRoomParameters(BookingInfoEntity bookingInfoEntity) {

		List<String> rooms = generateRooms(bookingInfoEntity.getNoOfRooms());
		for( String roomNo : rooms) {
			bookingInfoEntity.getRoomInfo().add(new RoomInfoEntity(roomNo));
		}
		int roomPrice = calculateRoomPrice(bookingInfoEntity);
		bookingInfoEntity.setRoomPrice(roomPrice);
		bookingInfoEntity.setBookedOn(LocalDateTime.now());
	}

	private int calculateRoomPrice(BookingInfoEntity bookingInfoEntity) {
		int noOfRooms = bookingInfoEntity.getNoOfRooms();
		int days = (int) ChronoUnit.DAYS.between(bookingInfoEntity.getFromDate(), bookingInfoEntity.getToDate());
		return (1000 * days * noOfRooms);
	}

	private List<String> generateRooms(int noOfRooms) {
		Random rand = new Random();
		int upperBound = 100;
		List<String> numberList = new ArrayList<String>();
		for (int i = 0; i < noOfRooms; i++) {
			numberList.add(String.valueOf(rand.nextInt(upperBound)));
		}
		return numberList;
	}

	@Override
	public BookingInfoEntity getBookingDetails(int bookingId) {
		try {
			BookingInfoEntity bookingInfo = bookingRepository.findById(bookingId).orElse(null);
			return bookingInfo;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public BookingInfoEntity getBookingDetails(BookingInfoEntity bookingInfo, PaymentDTO paymentDTO) {
		
		ResponseEntity<Integer> transactionNo = restTemplate.postForEntity(url, paymentDTO, Integer.class);
		bookingInfo.setTransactionId(transactionNo.getBody());
		return bookingRepository.save(bookingInfo);
	}
}
