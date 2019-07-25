package com.hcl.financialspendanalyzerapp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.financialspendanalyzerapp.dto.CustomerDTO;
import com.hcl.financialspendanalyzerapp.entity.Customer;
import com.hcl.financialspendanalyzerapp.repository.RegisterUserRepository;
import com.hcl.financialspendanalyzerapp.service.RegisterUserService;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

	@Autowired
	RegisterUserRepository registerUserRepository;
	
	/**
	 * @requestBody take user details from controller as DTO for 
	 * 				registration purpose and save the Customer Details .
	 * @return the generated Customer id
	 */
	@Override
	public String registerUser(CustomerDTO customer) {
		// TODO Auto-generated method stub
		
		Customer customerDetails = new Customer();
		customerDetails.setName(customer.getName());
		customerDetails.setGender(customer.getGender());
		customerDetails.setDob(customer.getDob());
		customerDetails.setPan(customer.getPan());
		customerDetails.setEmail(customer.getEmail());
		customerDetails.setPhone(customer.getPhone());
		
		return "";
	}
	
	
	
	
	
	
	
}
