package com.hcl.financialspendanalyzerapp.serviceimpl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.financialspendanalyzerapp.controller.TransferController;
import com.hcl.financialspendanalyzerapp.dto.PaymentDTO;
import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
import com.hcl.financialspendanalyzerapp.entity.Customer;
import com.hcl.financialspendanalyzerapp.entity.Transaction;
import com.hcl.financialspendanalyzerapp.exception.ApplicationException;
import com.hcl.financialspendanalyzerapp.repository.CustomerRepository;
import com.hcl.financialspendanalyzerapp.repository.TransactionRepository;
import com.hcl.financialspendanalyzerapp.service.OTPService;
import com.hcl.financialspendanalyzerapp.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService{
	
	private static final Logger logger = LoggerFactory.getLogger(TransferController.class);
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	OTPService oTPService;

	@Override
	@Transactional
	public ResponseDTO initiatTransaction(PaymentDTO paymentDTO) throws ApplicationException {
		logger.info("Payment transaction intitiated");
		ResponseDTO responseDTO = new ResponseDTO();
		
		Transaction transaction = new Transaction();
		transaction.setAmount(paymentDTO.getAmount());
		Optional<Customer> findByCustomerId = customerRepository.findByCustomerId(paymentDTO.getCustomerId());
		
		Customer savedCustomer;
		if(findByCustomerId.isPresent()) {
			savedCustomer = findByCustomerId.get();
		}else {
			throw new ApplicationException("Invalid Customer id.");
		}
		
<<<<<<< HEAD
		transaction.setCurrentBalance(savedCustomer.getAccountBalance() - paymentDTO.getAmount());
		transaction.setCustomerId(savedCustomer);
		transaction.setDate(LocalDateTime.now());
		transaction.setPaymentType(paymentDTO.getPaymentType());
		transaction.setStatus("pending");
		transaction.setTransDescription(paymentDTO.getPaymentType());
		Transaction savedTransaction = transactionRepository.save(transaction);
	//	OTPService.
		logger.debug("Payment transaction id : "+savedTransaction.getTransactionId());
		logger.info("Payment transaction intitiated");
=======
		try {
			transaction.setCurrentBalance(savedCustomer.getAccountBalance());
			transaction.setCustomerId(savedCustomer);
			transaction.setDate(LocalDateTime.now());
			transaction.setPaymentType(paymentDTO.getPaymentType());
			transaction.setStatus("pending");
			transaction.setTransDescription(paymentDTO.getPaymentType());
			Transaction savedTransaction = transactionRepository.save(transaction);
			
			//oTPService.generateOTP(paymentDTO.getCustomerId(), savedTransaction.getTransactionId());
			responseDTO.setMessage("Payment transaction intitiated sucessfully.");
			responseDTO.setHttpStatus(HttpStatus.OK);
			responseDTO.setData(savedTransaction);
			logger.debug("Payment transaction id : "+savedTransaction.getTransactionId());
			logger.info("Payment transaction intitiated");
			logger.info(""+responseDTO);
			return responseDTO;
		}catch(Exception e) {
			System.out.println(e);
		}
>>>>>>> a335d6c2a5bff45e9f1d63d1aa1facd2ca396c50
		return responseDTO;
		
		
		
	}

}
