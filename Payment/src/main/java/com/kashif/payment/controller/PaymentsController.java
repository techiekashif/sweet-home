package com.kashif.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kashif.payment.dto.PaymentDTO;
import com.kashif.payment.entity.TransactionDetailsEntity;
import com.kashif.payment.service.PaymentsService;
import com.kashif.payment.utils.POJOConverter;

@RestController
@RequestMapping(value = "/payment")
public class PaymentsController {

	@Autowired
	private PaymentsService paymentsService;

	@PostMapping(value = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> getTransactionID(@RequestBody PaymentDTO paymmentDTO) {
		TransactionDetailsEntity transaction = POJOConverter.convertTransactionDTOToEntity(paymmentDTO);
		int transactionId = paymentsService.saveTransaction(transaction).getId();
		return new ResponseEntity<Integer>(transactionId, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "transaction/{transactionId}")
	public ResponseEntity<PaymentDTO> getTransactionDetails(@PathVariable("transactionId") int id){
		TransactionDetailsEntity entity = paymentsService.getTransactionDetails(id);
		PaymentDTO paymentDTO =  POJOConverter.convertTransactionEntityToDTO(entity);
		return new ResponseEntity<PaymentDTO>(paymentDTO, HttpStatus.OK);
	}
}
