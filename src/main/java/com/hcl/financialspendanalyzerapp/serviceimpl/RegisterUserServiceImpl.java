package com.hcl.financialspendanalyzerapp.serviceimpl;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.financialspendanalyzerapp.dto.CustomerDTO;
import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
import com.hcl.financialspendanalyzerapp.entity.Customer;
import com.hcl.financialspendanalyzerapp.repository.CustomerRepository;
import com.hcl.financialspendanalyzerapp.service.RegisterUserService;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

	@Autowired
	CustomerRepository customerRepository;
	
	/**
	 * @requestBody take user details from controller as DTO for 
	 * 				registration purpose and save the Customer Details .
	 * @return the generated Customer id
	 */
	@Override
	public ResponseDTO registerUser(CustomerDTO customer) {
		// TODO Auto-generated method stub
		
		//int age =  Period.between(customer.getUserDOB(), LocalDate.now()).getYears();
		
		ResponseDTO responseDTOOject = new ResponseDTO();
		Customer customerDetailss = new Customer();
		
		String checkForCustomerExistOrNot = customerRepository.findByEmail(customer.getEmail());
		if(null == checkForCustomerExistOrNot){
			
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
			customerRepository.save(customerDetails);
			
			customer.setCustomerId(generatedCustomerId);

			
			
			
			responseDTOOject.setMessage("User registerd sucessfully");
			responseDTOOject.setData(customer);
			responseDTOOject.setHttpStatus(HttpStatus.OK);
									
			return responseDTOOject;
			
		}
		
		
		responseDTOOject.setMessage("Failed");
		responseDTOOject.setData(customerDetailss);
		responseDTOOject.setHttpStatus(HttpStatus.BAD_REQUEST);
								
		return responseDTOOject;
		
		
	}
	
	
	
	
	
	
	
}
