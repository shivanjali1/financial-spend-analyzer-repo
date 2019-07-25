package com.hcl.financialspendanalyzerapp.serviceimpl;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.financialspendanalyzerapp.entity.OtpDetails;
import com.hcl.financialspendanalyzerapp.repository.OTPRepository;
import com.hcl.financialspendanalyzerapp.service.OTPService;
import com.hcl.financialspendanalyzerapp.util.EmailUtil;

@RunWith(MockitoJUnitRunner.class)
public class OTPServiceImplTests {

	@Before
	public void setUp() {
	}

	@Mock
	OTPRepository oTPRepository;
	
	@InjectMocks
	OTPServiceImpl oTPService ;
	@Test
	public void testGenerateOTP() {
		OtpDetails otp = oTPService.generateOTP("", 1l);
		System.out.println("OTP ::::::::::::::::::: " + otp.getOtpCode());
		OtpDetails otp1 = oTPService.generateOTP("", 1l);
		System.out.println("OTP ::::::::::::::::::: " + otp1.getOtpCode());
		
		assertNotNull(otp);
	}

}
