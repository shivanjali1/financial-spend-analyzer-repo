package com.hcl.financialspendanalyzerapp.service;

import com.hcl.financialspendanalyzerapp.entity.OtpDetails;
import com.hcl.financialspendanalyzerapp.exception.ApplicationException;

public interface OTPService {
	
	OtpDetails generateOTP(String custId,Long tranId,String emailId);
	boolean validate(String custId, Long tranId,String otpToValidate) throws ApplicationException;

}
