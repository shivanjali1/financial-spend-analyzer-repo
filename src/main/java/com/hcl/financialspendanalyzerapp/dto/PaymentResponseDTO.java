package com.hcl.financialspendanalyzerapp.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PaymentResponseDTO {
	
	private Long transactionId;
	
	private String transDescription;
	
	private Double transactionAmount;
	
	private String paymentType;
	
	private LocalDateTime date;
	
	private String status;
	
	private String customerId;
	

}
