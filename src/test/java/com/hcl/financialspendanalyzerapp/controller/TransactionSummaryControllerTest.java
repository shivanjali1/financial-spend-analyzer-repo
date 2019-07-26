package com.hcl.financialspendanalyzerapp.controller;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
import com.hcl.financialspendanalyzerapp.entity.Customer;
import com.hcl.financialspendanalyzerapp.exception.ApplicationException;
import com.hcl.financialspendanalyzerapp.serviceimpl.TransactionSummaryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TransactionSummaryControllerTest {
	
	@InjectMocks
	TransactionSummaryController transactionSummaryController;
	
	@Mock
	TransactionSummaryServiceImpl transactionSummaryServiceImpl;
	
	ResponseDTO response;
	Customer customer;
	
	@Before
	public void setUp() {
		response= new ResponseDTO();
		customer = new Customer();
		customer.setAccountBalance(455000.0);
		customer.setAddress("Pune");
		customer.setDob(LocalDate.of(1992, 12, 11));
		customer.setEmail("sontrive0310@gmail.com");
		customer.setGender("female");
		customer.setName("Sonal");
		customer.setPan("AQWSEDT32R");
		customer.setPhone("1234567890");
		}
	
	@Test
	public void testSumary() throws ApplicationException {
		customer.setCustomerId("son123675432");
		
		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Success");
		response.setData(customer);
		
		Mockito.when(transactionSummaryServiceImpl.getSummaryDetails("son123675432")).thenReturn(response);
		ResponseEntity<ResponseDTO> responseDTO = transactionSummaryController.summary("son123675432");
		Assert.assertNotNull(responseDTO);
		Assert.assertNotNull(responseDTO.getBody());
		Assert.assertEquals(response.getMessage(), responseDTO.getBody().getMessage());
		
	}
	

}
