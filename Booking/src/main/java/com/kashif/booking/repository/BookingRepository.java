package com.kashif.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kashif.booking.entity.BookingInfoEntity;

public interface BookingRepository extends JpaRepository<BookingInfoEntity, Integer> {

}
