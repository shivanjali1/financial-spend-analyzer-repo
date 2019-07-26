package com.hcl.financialspendanalyzerapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
import com.hcl.financialspendanalyzerapp.exception.ApplicationException;
import com.hcl.financialspendanalyzerapp.serviceimpl.TransactionSummaryServiceImpl;

@CrossOrigin
@RestController
public class TransactionSummaryController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionSummaryController.class); 
	
	@Autowired
	private TransactionSummaryServiceImpl transactionSummaryServiceImpl;
	
	
	@GetMapping("/summary/{customerId}")
	public ResponseEntity<ResponseDTO> summary(@PathVariable String customerId) throws ApplicationException{
		
		logger.info("Got customer id");
		
		if (null == customerId || "".equalsIgnoreCase(customerId)) {
			throw new ApplicationException("Please enter valid Customer Id...");
		}
		else {
			logger.debug("Customer Id received is "+ customerId);
			ResponseDTO transactions= transactionSummaryServiceImpl.getSummaryDetails(customerId);
			logger.debug("Summary details for the customer are " + transactions );
			return new ResponseEntity<ResponseDTO>(transactions,HttpStatus.OK);
		}
	}

}
