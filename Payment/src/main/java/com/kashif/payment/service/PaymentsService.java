package com.kashif.payment.service;

import com.kashif.payment.entity.TransactionDetailsEntity;

public interface PaymentsService {
	
	public TransactionDetailsEntity saveTransaction(TransactionDetailsEntity transaction);
	
	public TransactionDetailsEntity getTransactionDetails(int id);

}
