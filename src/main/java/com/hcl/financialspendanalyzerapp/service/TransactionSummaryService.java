package com.hcl.financialspendanalyzerapp.service;

import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
import com.hcl.financialspendanalyzerapp.exception.CustomerNotFoundException;

public interface TransactionSummaryService {
	
	public ResponseDTO getSummaryDetails(String customerId) throws CustomerNotFoundException;

}
