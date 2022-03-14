package com.kashif.booking.dto;

import java.sql.Date;
import java.time.LocalDate;

public class BookingDTO {
	
	private int bookingId;
	private Date fromDate;
	private Date toDate;
	private String adhaarNo;
	private int noOfRooms;
	private String roomNumbers;
	private int roomPrice;
	private int transactionId;
	private LocalDate bookedOn;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getAdhaarNo() {
		return adhaarNo;
	}
	public void setAdhaarNo(String adhaarNo) {
		this.adhaarNo = adhaarNo;
	}
	public int getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public String getRoomNumbers() {
		return roomNumbers;
	}
	public void setRoomNumbers(String roomNumbers) {
		this.roomNumbers = roomNumbers;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public LocalDate getBookedOn() {
		return bookedOn;
	}
	public void setBookedOn(LocalDate bookedOn) {
		this.bookedOn = bookedOn;
	}
	
	
}
