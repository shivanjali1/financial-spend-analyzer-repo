package com.hcl.financialspendanalyzerapp.dto;

import lombok.Data;

@Data
public class PaymentDTO {
	
	private String customerId;
	
	private String transDescription;
	
	private Double amount;
	
	private String paymentType;

}
