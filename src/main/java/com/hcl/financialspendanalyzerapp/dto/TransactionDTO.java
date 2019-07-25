package com.hcl.financialspendanalyzerapp.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionDTO {
		
	private String transDescription;
	
	private Double amount;
	
	private String paymentType;
	
	private LocalDateTime date;
	
	private Double currentBalance;

}
