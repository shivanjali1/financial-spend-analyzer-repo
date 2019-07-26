package com.hcl.financialspendanalyzerapp.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

		Mockito.when(registerUserServiceImpl.registerUser(customerForTest)).thenReturn(responseDTO);
		assertNotNull(registerUserController.registerUser(customerForTest));
	}

	@Test(expected = ApplicationException.class)
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

		registerUserServiceImpl.registerUser(customerForTest);
		assertNull(registerUserController.registerUser(customerForTest));
	}

	@Test(expected = ApplicationException.class)
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

		registerUserServiceImpl.registerUser(customerForTest);
		assertNotNull(registerUserController.registerUser(customerForTest));
	}

	@Test(expected = ApplicationException.class)
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

		registerUserServiceImpl.registerUser(customerForTest);
		assertNull(registerUserController.registerUser(customerForTest));
	}

	@Test(expected = ApplicationException.class)
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

		registerUserServiceImpl.registerUser(customerForTest);
		assertNull(registerUserController.registerUser(customerForTest));
	}

	@Test(expected = ApplicationException.class)
	public void registerUserWithUserPanEmptyTest() throws ApplicationException {

		customerForTest.setName("sagar");
		customerForTest.setGender("male");
		customerForTest.setDob(LocalDate.of(1992, 10, 10));
		customerForTest.setPan("");
		customerForTest.setEmail("a@b.com");
		customerForTest.setPhone("123456");
		customerForTest.setAddress("Pune");

		responseDTO.setHttpStatus(HttpStatus.BAD_REQUEST);
		responseDTO.setMessage("Failed");
		responseDTO.setData(customerForTest);

		registerUserServiceImpl.registerUser(customerForTest);
		assertNull(registerUserController.registerUser(customerForTest));
	}

	@Test(expected = ApplicationException.class)
	public void registerUserEmptyTest() throws ApplicationException {

		customerForTest.setName("");
		customerForTest.setGender("");
		customerForTest.setDob(LocalDate.of(1992, 10, 10));
		customerForTest.setPan("");
		customerForTest.setEmail("");
		customerForTest.setPhone("");
		customerForTest.setAddress("");

		responseDTO.setHttpStatus(HttpStatus.BAD_REQUEST);
		responseDTO.setMessage("Failed");
		responseDTO.setData(customerForTest);

		assertFalse(customerForTest.equals(null));
		assertNull(registerUserController.registerUser(customerForTest));
	}

	
	@Test(expected = ApplicationException.class)
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

		registerUserServiceImpl.registerUser(customerForTest);
		assertNull(registerUserController.registerUser(customerForTest));
	}

	@Test(expected = ApplicationException.class)
	public void registerUserDOBEmptyTest() throws ApplicationException {

		customerForTest.setName("sagar");
		customerForTest.setGender("male");
		customerForTest.setDob(null);
		customerForTest.setPan("MNHL789L");
		customerForTest.setEmail("a@b.com");
		customerForTest.setPhone("123456");
		customerForTest.setAddress("Pune");

		responseDTO.setHttpStatus(HttpStatus.BAD_REQUEST);
		responseDTO.setMessage("Failed");
		responseDTO.setData(customerForTest);

		registerUserServiceImpl.registerUser(customerForTest);
		assertNull(registerUserController.registerUser(customerForTest));
	}

}
