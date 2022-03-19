package com.kashif.booking.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BookingResponseDTO {
	
	private int bookingId;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String adhaarNo;
	private List<String> roomNumbers;
	private int roomPrice;
	private int transactionId;
	private LocalDateTime bookedOn;
	
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
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
	public LocalDateTime getBookedOn() {
		return bookedOn;
	}
	public void setBookedOn(LocalDateTime localDate) {
		this.bookedOn = localDate;
	}
	@Override
	public String toString() {
		return "[bookingId=" + bookingId + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", adhaarNo=" + adhaarNo + ", roomNumbers=" + roomNumbers + ", roomPrice=" + roomPrice
				+ ", transactionId=" + transactionId + ", bookedOn=" + bookedOn + "]";
	}
}
