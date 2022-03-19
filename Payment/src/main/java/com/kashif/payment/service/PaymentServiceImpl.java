package com.kashif.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kashif.payment.entity.TransactionDetailsEntity;
import com.kashif.payment.repository.TransactionRepository;

@Service
public class PaymentServiceImpl implements PaymentsService{

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public TransactionDetailsEntity saveTransaction(TransactionDetailsEntity transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public TransactionDetailsEntity getTransactionDetails(int id) {
		return transactionRepository.findById(id).orElse(null);
	}
}
