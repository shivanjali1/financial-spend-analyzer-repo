package com.hcl.financialspendanalyzerapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
import com.hcl.financialspendanalyzerapp.entity.Customer;
import com.hcl.financialspendanalyzerapp.entity.Transaction;
import com.hcl.financialspendanalyzerapp.exception.CustomerNotFoundException;
import com.hcl.financialspendanalyzerapp.repository.CustomerRepository;
import com.hcl.financialspendanalyzerapp.service.TransactionSummaryService;

@Service
public class TransactionSummaryServiceImpl implements TransactionSummaryService {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionSummaryServiceImpl.class); 
	/*
	 * @Autowired private TransactionRepository transactionRepository;
	 */
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public ResponseDTO getSummaryDetails(String customerId) throws CustomerNotFoundException{
		
		logger.info("Inside Service method");
		Optional<Customer> customer = customerRepository.findByCustomerId(customerId);
			if (customer.isPresent()) {
				List<Transaction> transactions= customer.get().getTransactionList();
				ResponseDTO response = new ResponseDTO();
				response.setHttpStatus(HttpStatus.OK);
				response.setMessage("Current Transactions");
				response.setData(transactions);
				return response;
				
			}
			throw new CustomerNotFoundException("Account of customer is not present..");
		}
	}


