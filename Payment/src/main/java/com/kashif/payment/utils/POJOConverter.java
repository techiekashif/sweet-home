package com.kashif.payment.utils;

import com.kashif.payment.dto.PaymentDTO;
import com.kashif.payment.entity.TransactionDetailsEntity;

public class POJOConverter {
	
	public static TransactionDetailsEntity convertTransactionDTOToEntity(PaymentDTO paymentDto) {
		TransactionDetailsEntity entity = new TransactionDetailsEntity();
		entity.setBookingId(paymentDto.getBookingId());
		entity.setCardNumber(paymentDto.getCardNumber());
		entity.setPaymentMode(paymentDto.getPaymentMode());
		entity.setUpiId(paymentDto.getUpiId());
		return entity;
	}
	
	public static PaymentDTO convertTransactionEntityToDTO(TransactionDetailsEntity entity) {
		PaymentDTO paymentDto = new PaymentDTO();
		paymentDto.setId(entity.getId());
		paymentDto.setBookingId(entity.getBookingId());
		paymentDto.setCardNumber(entity.getCardNumber());
		paymentDto.setPaymentMode(entity.getPaymentMode());
		paymentDto.setUpiId(entity.getUpiId());
		return paymentDto;
	}
	

}
