package com.hcl.financialspendanalyzerapp.controller;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.financialspendanalyzerapp.dto.CustomerDTO;
import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
import com.hcl.financialspendanalyzerapp.exception.ApplicationException;
import com.hcl.financialspendanalyzerapp.serviceimpl.RegisterUserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RegisterUserControllerTest {

	@InjectMocks
	RegisterUserController registerUserController;

	@Mock
	RegisterUserServiceImpl registerUserServiceImpl;

	CustomerDTO customerForTest;
	ResponseDTO responseDTO;

	@Before
	public void setUp() {

		customerForTest = new CustomerDTO();

		responseDTO = new ResponseDTO();

	}

	@Test
	public void registerUserTest() throws ApplicationException {

		customerForTest.setName("sagar");
		customerForTest.setGender("male");
		customerForTest.setDob(LocalDate.of(1992, 10, 10));
		customerForTest.setPan("HJGY6788L");
		customerForTest.setEmail("a@b.com");
		customerForTest.setPhone("123456");
		customerForTest.setAddress("Pune");

		responseDTO.setHttpStatus(HttpStatus.OK);
		responseDTO.setMessage("Success");
		responseDTO.setData(customerForTest);

		//registerUserController.validateRequest(customerForTest);
		Mockito.when(registerUserServiceImpl.registerUser(customerForTest)).thenReturn(responseDTO);
		assertNotNull(registerUserController.registerUser(customerForTest));
	}


	@Test
	public void registerUserWithUserNameEmptyTest() throws ApplicationException {

		customerForTest.setName("");
		customerForTest.setGender("male");
		customerForTest.setDob(LocalDate.of(1992, 10, 10));
		customerForTest.setPan("HJGY6788L");
		customerForTest.setEmail("a@b.com");
		customerForTest.setPhone("123456");
		customerForTest.setAddress("Pune");

		responseDTO.setHttpStatus(HttpStatus.BAD_REQUEST);
		responseDTO.setMessage("Failed");
		responseDTO.setData(customerForTest);

		Mockito.when(registerUserServiceImpl.registerUser(customerForTest)).thenReturn(responseDTO);
		assertNotNull(registerUserController.registerUser(customerForTest));
	}
	
	@Test
	public void registerUserWithUserGenderEmptyTest() throws ApplicationException {

		customerForTest.setName("sagar");
		customerForTest.setGender("");
		customerForTest.setDob(LocalDate.of(1992, 10, 10));
		customerForTest.setPan("HJGY6788L");
		customerForTest.setEmail("a@b.com");
		customerForTest.setPhone("123456");
		customerForTest.setAddress("Pune");

		responseDTO.setHttpStatus(HttpStatus.BAD_REQUEST);
		responseDTO.setMessage("Failed");
		responseDTO.setData(customerForTest);

		Mockito.when(registerUserServiceImpl.registerUser(customerForTest)).thenReturn(responseDTO);
		assertNotNull(registerUserController.registerUser(customerForTest));
	}
	
		
	
	@Test
	public void registerUserWithUserEmailEmptyTest() throws ApplicationException {

		customerForTest.setName("sagar");
		customerForTest.setGender("male");
		customerForTest.setDob(LocalDate.of(1992, 10, 10));
		customerForTest.setPan("HJGY6788L");
		customerForTest.setEmail("");
		customerForTest.setPhone("123456");
		customerForTest.setAddress("Pune");

		responseDTO.setHttpStatus(HttpStatus.BAD_REQUEST);
		responseDTO.setMessage("Failed");
		responseDTO.setData(customerForTest);

		Mockito.when(registerUserServiceImpl.registerUser(customerForTest)).thenReturn(responseDTO);
		assertNotNull(registerUserController.registerUser(customerForTest));
	}
	
	@Test
	public void registerUserWithUserPhoneEmptyTest() throws ApplicationException {

		customerForTest.setName("sagar");
		customerForTest.setGender("male");
		customerForTest.setDob(LocalDate.of(1992, 10, 10));
		customerForTest.setPan("HJGY6788L");
		customerForTest.setEmail("sagar@gmail.com");
		customerForTest.setPhone("");
		customerForTest.setAddress("Pune");

		responseDTO.setHttpStatus(HttpStatus.BAD_REQUEST);
		responseDTO.setMessage("Failed");
		responseDTO.setData(customerForTest);

		Mockito.when(registerUserServiceImpl.registerUser(customerForTest)).thenReturn(responseDTO);
		assertNotNull(registerUserController.registerUser(customerForTest));
	}
	
	@Test
	public void registerUserWithUserAddressEmptyTest() throws ApplicationException {

		customerForTest.setName("sagar");
		customerForTest.setGender("male");
		customerForTest.setDob(LocalDate.of(1992, 10, 10));
		customerForTest.setPan("HJGY6788L");
		customerForTest.setEmail("sagar@gmail.com");
		customerForTest.setPhone("123456");
		customerForTest.setAddress("");

		responseDTO.setHttpStatus(HttpStatus.BAD_REQUEST);
		responseDTO.setMessage("Failed");
		responseDTO.setData(customerForTest);

		Mockito.when(registerUserServiceImpl.registerUser(customerForTest)).thenReturn(responseDTO);
		assertNotNull(registerUserController.registerUser(customerForTest));
	}
	

}
