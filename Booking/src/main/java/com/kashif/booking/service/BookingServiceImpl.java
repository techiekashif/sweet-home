package com.kashif.booking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kashif.booking.entity.BookingInfoEntity;
import com.kashif.booking.entity.RoomInfoEntity;
import com.kashif.booking.repository.BookingRepository;
import com.kashif.booking.repository.RoomRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public BookingInfoEntity createBooking(BookingInfoEntity bookingInfo) {
		populateRoomParameters(bookingInfo);
		BookingInfoEntity bookingInfoEntity = bookingRepository.save(bookingInfo);
		return bookingInfoEntity;
	}

	private void populateRoomParameters(BookingInfoEntity bookingInfoEntity) {

		int noOfRooms = bookingInfoEntity.getNoOfRooms();
		List<String> rooms = generateRooms(bookingInfoEntity.getNoOfRooms());
		for( String roomNo : rooms) {
			bookingInfoEntity.getRoomInfo().add(new RoomInfoEntity(roomNo));
		}
		int roomPrice = calculateRoomPrice(bookingInfoEntity);
		bookingInfoEntity.setRoomPrice(roomPrice);
		bookingInfoEntity.setBookedOn(LocalDate.now());
	}

	private int calculateRoomPrice(BookingInfoEntity bookingInfoEntity) {
		int noOfRooms = bookingInfoEntity.getNoOfRooms();
		int days = bookingInfoEntity.getToDate().getDate() - bookingInfoEntity.getFromDate().getDate();
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

}
