package com.hcl.financialspendanalyzerapp.service;

import com.hcl.financialspendanalyzerapp.entity.OtpDetails;

public interface OTPService {
	
	OtpDetails generateOTP(String custId,Long tranId);
	boolean validate(String custId, Long tranId);

}
