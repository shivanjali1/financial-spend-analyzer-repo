package com.hcl.financialspendanalyzerapp.serviceimpl;

import java.util.Random;

import com.hcl.financialspendanalyzerapp.entity.OtpDetails;
import com.hcl.financialspendanalyzerapp.service.OTPService;

public class OTPServiceImpl implements OTPService {

	private final static int otpLength = 6; 
	
	@Override
	public OtpDetails generateOTP(String custId, Long tranId) {
		// TODO Auto-generated method stub
		String otpStr = getRanOTP(otpLength);
		
		return null;
	}

	@Override
	public boolean validate(OtpDetails otp) {
		// TODO Auto-generated method stub
		return false;
	}

	private String getRanOTP(int len) {
		// Using numeric values
		String numbers = "0123456789";

		// Using random method
		Random rndm_method = new Random();

		char[] otp = new char[len];

		for (int i = 0; i < len; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return new String(otp);
	}
}
