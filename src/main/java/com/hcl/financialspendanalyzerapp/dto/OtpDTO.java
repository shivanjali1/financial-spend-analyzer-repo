package com.hcl.financialspendanalyzerapp.dto;

import lombok.Data;

@Data
public class OtpDTO {
	
	private String customerId;
	
	private String otpCode;
	
	private Long transactionId;


}
