package com.kashif.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kashif.booking.entity.RoomInfoEntity;

public interface RoomRepository extends JpaRepository<RoomInfoEntity, Integer> {

}
