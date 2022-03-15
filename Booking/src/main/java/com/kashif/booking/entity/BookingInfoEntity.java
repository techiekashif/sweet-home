package com.kashif.booking.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class BookingInfoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private int bookingId;
	
	@Column
	private Date fromDate;
	
	@Column
	private Date toDate;
	
	@Column
	private String adhaarNo;
	
	@Column
	private int numOfRooms;
	@Column(nullable = false)
	private int roomPrice;
	
	@Column(columnDefinition = "int DEFAULT 0")
	private int transactionId;
	
	@Column
	private LocalDate bookedOn;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_room_id", referencedColumnName = "booking_id")
	private Collection<RoomInfoEntity> roomInfo = new ArrayList<RoomInfoEntity>();
	

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
		return numOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.numOfRooms = noOfRooms;
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

	public int getNumOfRooms() {
		return numOfRooms;
	}

	public void setNumOfRooms(int numOfRooms) {
		this.numOfRooms = numOfRooms;
	}

	public Collection<RoomInfoEntity> getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(List<RoomInfoEntity> roomInfo) {
		this.roomInfo = roomInfo;
	}
	
}
