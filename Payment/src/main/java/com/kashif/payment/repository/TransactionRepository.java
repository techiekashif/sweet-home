package com.kashif.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kashif.payment.entity.TransactionDetailsEntity;

public interface TransactionRepository extends JpaRepository<TransactionDetailsEntity, Integer> {

}
