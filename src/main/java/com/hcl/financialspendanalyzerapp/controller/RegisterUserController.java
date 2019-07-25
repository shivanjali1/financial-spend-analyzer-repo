package com.hcl.financialspendanalyzerapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/register")
public class RegisterUserController {
	
	/**
	 * @requestBody take user details from user for 
	 * 				registration purpose pass it as DTO to service.
	 * @return the generated Customer id
	 */
	@PostMapping()
	public ResponseEntity<String> registerUser(){
		
		
		return new ResponseEntity<>(" Welcome to ING Bank.\n There’s the DONE thing and then there’s the ING way. \n\n Your customer id is",HttpStatus.OK);
		
		
	}
	
}
