package com.hcl.financialspendanalyzerapp.service;

import com.hcl.financialspendanalyzerapp.dto.OtpDTO;
import com.hcl.financialspendanalyzerapp.dto.PaymentDTO;
import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
import com.hcl.financialspendanalyzerapp.exception.ApplicationException;

public interface TransferService {
	
	public ResponseDTO initiatTransaction(PaymentDTO paymentDTO) throws ApplicationException;
	
	public ResponseDTO validateTransaction(OtpDTO otpDTO) throws ApplicationException;
}
