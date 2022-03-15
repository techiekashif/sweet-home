package com.kashif.booking.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class BookingResponseDTO {
	
	private int bookingId;
	private Date fromDate;
	private Date toDate;
	private String adhaarNo;
	private List<String> roomNumbers;
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
	public List<String> getRoomNumbers() {
		return roomNumbers;
	}
	public void setRoomNumbers(List<String> roomNumbers) {
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
	public void setBookedOn(LocalDate localDate) {
		this.bookedOn = localDate;
	}
	
	
}
