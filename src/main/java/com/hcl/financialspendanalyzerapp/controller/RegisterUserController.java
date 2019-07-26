package com.hcl.financialspendanalyzerapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class RegisterUserController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterUserController.class);

	private static final String ERROR_MSG = "Mandetory Element missing : ";

	@Autowired
	RegisterUserServiceImpl registerUserServiceImpl;

	/**
	 * @requestBody take user details from user for registration purpose pass it as
	 *              DTO to service.
	 * @return the generated Customer id
	 * @throws ApplicationException throws custom exception
	 * 
	 */
	@PostMapping
	public ResponseEntity<Object> registerUser(@RequestBody CustomerDTO customer) throws ApplicationException {

		
		validateRequest(customer);
		ResponseDTO returnedResponseObject = registerUserServiceImpl.registerUser(customer);
	
		if ("Failed".equals(returnedResponseObject.getMessage())) {
			throw new ApplicationException("Account Already Exist with Same email id");
		}

		return new ResponseEntity<>(returnedResponseObject, HttpStatus.OK);

	}

	private void validateRequest(CustomerDTO customer) throws ApplicationException {
		if (ObjectUtils.isEmpty(customer)) {
			throw new ApplicationException("Invalid request");
		}
		if (StringUtils.isEmpty(customer.getName())) {
			throw new ApplicationException(ERROR_MSG + "Name");
		}
		if (StringUtils.isEmpty(customer.getGender())) {
			throw new ApplicationException(ERROR_MSG + "Customer Id");
		}
		if (StringUtils.isEmpty(customer.getAddress())) {
			throw new ApplicationException(ERROR_MSG + "getAddress");
		}
		if (StringUtils.isEmpty(customer.getEmail())) {
			throw new ApplicationException(ERROR_MSG + "Email");
		}
		if (StringUtils.isEmpty(customer.getPan())) {
			throw new ApplicationException(ERROR_MSG + "Pan");
		}
		if (StringUtils.isEmpty(customer.getDob())) {
			throw new ApplicationException(ERROR_MSG + "Dob");
		}
		if (StringUtils.isEmpty(customer.getPhone())) {
			throw new ApplicationException(ERROR_MSG + "Phone");
		}
	}

}
