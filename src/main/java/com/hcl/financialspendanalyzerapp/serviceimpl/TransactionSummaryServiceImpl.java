package com.hcl.financialspendanalyzerapp.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
import com.hcl.financialspendanalyzerapp.dto.TransactionDTO;
import com.hcl.financialspendanalyzerapp.entity.Customer;
import com.hcl.financialspendanalyzerapp.entity.Transaction;
import com.hcl.financialspendanalyzerapp.exception.CustomerNotFoundException;
import com.hcl.financialspendanalyzerapp.repository.CustomerRepository;
import com.hcl.financialspendanalyzerapp.repository.TransactionRepository;
import com.hcl.financialspendanalyzerapp.service.TransactionSummaryService;
import com.hcl.financialspendanalyzerapp.util.TransactionMapper;

import org.springframework.data.domain.Sort; 

@Service
public class TransactionSummaryServiceImpl implements TransactionSummaryService {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionSummaryServiceImpl.class); 
	/*
	 * @Autowired private TransactionRepository transactionRepository;
	 */
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public ResponseDTO getSummaryDetails(String customerId) throws CustomerNotFoundException{
		
		logger.info("Inside Service method");
		Optional<Customer> optopnalCustomer = customerRepository.findByCustomerId(customerId);
		
	
			if (optopnalCustomer.isPresent()) {
				Pageable page=PageRequest.of(0, 10, Sort.by("date").descending());
			List<Transaction> transactions = transactionRepository.findTransactionDetails(optopnalCustomer.get().getId(),page);
			 
			 List<TransactionDTO> respList = new ArrayList<>();
			 transactions.forEach(u -> {
					respList.add(TransactionMapper.mapTransactionDTOToResponseList(u));

				});
			ResponseDTO response = new ResponseDTO();
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Transactions summary");
			response.setData(respList);
			return response;
		}
			else {
				throw new CustomerNotFoundException("Invalid customer id");
			}
	}
}


