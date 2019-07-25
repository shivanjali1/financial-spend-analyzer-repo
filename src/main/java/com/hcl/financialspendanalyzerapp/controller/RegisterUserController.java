package com.hcl.financialspendanalyzerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.financialspendanalyzerapp.dto.CustomerDTO;
import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
import com.hcl.financialspendanalyzerapp.serviceimpl.RegisterUserServiceImpl;

@RestController
@RequestMapping(value = "/register")
public class RegisterUserController {
	
	@Autowired
	RegisterUserServiceImpl registerUserServiceImpl;
	
	/**
	 * @requestBody take user details from user for 
	 * 				registration purpose pass it as DTO to service.
	 * @return the generated Customer id
	 */
	@PostMapping
	public ResponseEntity<ResponseDTO> registerUser(@RequestBody CustomerDTO customer){
		
		ResponseDTO returnedCustomer = registerUserServiceImpl.registerUser(customer);
		return new ResponseEntity<>(returnedCustomer,HttpStatus.OK);
		
		
	}
	
}
