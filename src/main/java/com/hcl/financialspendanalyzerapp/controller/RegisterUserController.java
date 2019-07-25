package com.hcl.financialspendanalyzerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.financialspendanalyzerapp.dto.CustomerDTO;
import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
import com.hcl.financialspendanalyzerapp.exception.ApplicationException;
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
	 * @throws ApplicationException throws custom exception
	 * 
	 */
	@PostMapping
	public ResponseEntity<?> registerUser(@RequestBody CustomerDTO customer) throws ApplicationException{
		
		
		if("" != customer.getName() && "" != customer.getGender() && null != customer.getDob() && "" != customer.getPan()
		&& "" != customer.getEmail() 
		&& "" != customer.getPhone()
		&& "" != customer.getAddress()) {
			
				ResponseDTO returnedResponseObject = registerUserServiceImpl.registerUser(customer);
				if( "Failed".equals(returnedResponseObject.getMessage())) {
					throw new ApplicationException("Account Already Exist with Same email id");
				}
				
			
		}
		return new ResponseEntity<String>("Enter Valid Details",HttpStatus.OK);
		
			
		
	}
	
}
