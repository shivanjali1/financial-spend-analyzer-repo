package com.hcl.financialspendanalyzerapp.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.hcl.financialspendanalyzerapp.entity.Customer;

import lombok.Data;

@Data
public class CustomerDTO {

	private Long id;
	private String name;
	private LocalDateTime dob;
	private String gender;
	private String pan;
	private String phone;
	private String email;
	private String address;
	private double accountBalance;
	private String customerId;
	
}
