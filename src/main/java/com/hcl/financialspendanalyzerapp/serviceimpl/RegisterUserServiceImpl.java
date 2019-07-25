package com.hcl.financialspendanalyzerapp.serviceimpl;

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
		
		
		
		Customer customerDetails = new Customer();
		customerDetails.setName(customer.getName());
		customerDetails.setGender(customer.getGender());
		customerDetails.setDob(customer.getDob());
		customerDetails.setPan(customer.getPan());
		customerDetails.setEmail(customer.getEmail());
		customerDetails.setPhone(customer.getPhone());
		customerDetails.setAddress(customer.getAddress());
		
		String generatedCustomerId =  customer.getName().substring(0,3) + customer.getPhone().substring(0,3) + System.currentTimeMillis()/3600;
		
		customerDetails.setCustomerId(generatedCustomerId);;
		Customer savedCustomer = registerUserRepository.save(customerDetails);
		
		ResponseDTO responseDTOOject = new ResponseDTO();
		responseDTOOject.setErrorMessage(" Welcome to ING Bank.\n There’s the DONE thing and then there’s the ING way. \n\n Your customer id is -->"+savedCustomer.getCustomerId());
		responseDTOOject.setData(savedCustomer);
		responseDTOOject.setHttpStatus(HttpStatus.OK);
		
		return responseDTOOject;
	}
	
	
	
	
	
	
	
}
