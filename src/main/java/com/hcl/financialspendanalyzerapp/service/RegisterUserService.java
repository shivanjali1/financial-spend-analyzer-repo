package com.hcl.financialspendanalyzerapp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.financialspendanalyzerapp.dto.CustomerDTO;

public interface RegisterUserService {

	public String registerUser(@RequestBody CustomerDTO customer);
	
	
}
