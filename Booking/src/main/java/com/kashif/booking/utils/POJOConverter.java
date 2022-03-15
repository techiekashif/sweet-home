package com.kashif.booking.utils;

import java.util.ArrayList;
import java.util.List;

import com.kashif.booking.dto.BookingRequestDTO;
import com.kashif.booking.dto.BookingResponseDTO;
import com.kashif.booking.entity.BookingInfoEntity;
import com.kashif.booking.entity.RoomInfoEntity;

public class POJOConverter {
	
	public static BookingInfoEntity convertBookingToEntity(BookingRequestDTO bookingRequestDTO) {
		BookingInfoEntity bookingInfoEntity = new BookingInfoEntity();
		bookingInfoEntity.setAdhaarNo(bookingRequestDTO.getAdhaarNo());
		bookingInfoEntity.setFromDate(bookingRequestDTO.getFromDate());
		bookingInfoEntity.setToDate(bookingRequestDTO.getToDate());
		bookingInfoEntity.setNoOfRooms(bookingRequestDTO.getNumOfRooms());
		return bookingInfoEntity;
	}
	
	public static BookingResponseDTO convertEntityToDTO(BookingInfoEntity bookingInfoEntity) {
		BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
		bookingResponseDTO.setBookingId(bookingInfoEntity.getBookingId());
		bookingResponseDTO.setAdhaarNo(bookingInfoEntity.getAdhaarNo());
		bookingResponseDTO.setFromDate(bookingInfoEntity.getFromDate());
		bookingResponseDTO.setToDate(bookingInfoEntity.getToDate());
		List<String> rooms = new ArrayList<String>();
		for(RoomInfoEntity roomInfo : bookingInfoEntity.getRoomInfo()) {
			rooms.add(roomInfo.getRoomNumber());
		}
		bookingResponseDTO.setRoomNumbers(rooms);
		bookingResponseDTO.setRoomPrice(bookingInfoEntity.getRoomPrice());
		bookingResponseDTO.setTransactionId(bookingInfoEntity.getTransactionId());
		bookingResponseDTO.setBookedOn(bookingInfoEntity.getBookedOn());
		return bookingResponseDTO;
	}

}
