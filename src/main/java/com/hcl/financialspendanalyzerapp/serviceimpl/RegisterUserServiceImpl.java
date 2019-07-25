package com.hcl.financialspendanalyzerapp.serviceimpl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.financialspendanalyzerapp.dto.CustomerDTO;
import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
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
	public ResponseDTO registerUser(CustomerDTO customer) {
		// TODO Auto-generated method stub
		String checkForCustomerExistOrNot = registerUserRepository.findByIdEmail(customer.getEmail());

		Customer customerDetails = new Customer();
		customerDetails.setName(customer.getName());
		customerDetails.setGender(customer.getGender());
		customerDetails.setDob(customer.getDob());
		customerDetails.setPan(customer.getPan());
		customerDetails.setEmail(customer.getEmail());
		customerDetails.setPhone(customer.getPhone());
		customerDetails.setAddress(customer.getAddress());
		
		String generatedCustomerId =  customer.getName().substring(0,3) + customer.getPhone().substring(0,3) + System.currentTimeMillis()/3600;
		
		customerDetails.setCustomerId(generatedCustomerId);
		registerUserRepository.save(customerDetails);
		
			
		customer.setCustomerId(generatedCustomerId);
		
		
		ResponseDTO responseDTOOject = new ResponseDTO();
		responseDTOOject.setMessage("Success");
		responseDTOOject.setData(customer);
		responseDTOOject.setHttpStatus(HttpStatus.OK);
		
		
		
		return responseDTOOject;
	}
	
	
	
	
	
	
	
}
