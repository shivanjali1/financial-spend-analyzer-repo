package com.hcl.financialspendanalyzerapp.serviceimpl;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.financialspendanalyzerapp.entity.OtpDetails;
import com.hcl.financialspendanalyzerapp.exception.ApplicationException;
import com.hcl.financialspendanalyzerapp.repository.OTPRepository;
import com.hcl.financialspendanalyzerapp.service.OTPService;
import com.hcl.financialspendanalyzerapp.util.EmailUtil;

@Service
public class OTPServiceImpl implements OTPService {

	private final static int otpLength = 6; 
	private final static int expireTime=5;

	@Autowired
	OTPRepository oTPRepository;
	
	@Override
	public OtpDetails generateOTP(String custId, Long tranId) {
		// TODO Auto-generated method stub
		String otpCode = getRanOTP(otpLength);
		OtpDetails otp = new OtpDetails();
		otp.setCustomerId(custId);
		otp.setOtpCode(otpCode);
		otp.setTime(LocalDateTime.now());
		otp.setTransactionId(tranId);
		oTPRepository.save(otp);
		EmailUtil.sendEmail();
		return otp;
	}

	@Override
	public boolean validate(String custId, Long tranId,String otpToValidate) throws ApplicationException {
		// TODO Auto-generated method stub
		OtpDetails otp = oTPRepository.getOtpDetailsByTransIdAndCustId(custId, tranId);
		if(otp != null) {
			if(otp.getOtpCode().equals(otpToValidate)) {
				return true;
			}
		}
		
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
