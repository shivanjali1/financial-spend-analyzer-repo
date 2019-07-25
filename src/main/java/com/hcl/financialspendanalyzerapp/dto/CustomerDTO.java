package com.hcl.financialspendanalyzerapp.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CustomerDTO {


	private String name;
	private LocalDate dob;
	private String gender;
	private String pan;
	private String phone;
	private String email;
	private String address;
	private double accountBalance;
	private String customerId;

	
}
