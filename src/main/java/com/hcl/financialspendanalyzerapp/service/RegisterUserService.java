package com.hcl.financialspendanalyzerapp.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.financialspendanalyzerapp.dto.CustomerDTO;
import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;

public interface RegisterUserService {

	public ResponseDTO registerUser(@RequestBody CustomerDTO customer);
	
	
}
