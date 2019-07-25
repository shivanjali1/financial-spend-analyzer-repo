package com.hcl.financialspendanalyzerapp.serviceimpl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.financialspendanalyzerapp.controller.TransferController;
import com.hcl.financialspendanalyzerapp.dto.OtpDTO;
import com.hcl.financialspendanalyzerapp.dto.PaymentDTO;
import com.hcl.financialspendanalyzerapp.dto.PaymentResponseDTO;
import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
import com.hcl.financialspendanalyzerapp.entity.Customer;
import com.hcl.financialspendanalyzerapp.entity.Transaction;
import com.hcl.financialspendanalyzerapp.exception.ApplicationException;
import com.hcl.financialspendanalyzerapp.repository.CustomerRepository;
import com.hcl.financialspendanalyzerapp.repository.TransactionRepository;
import com.hcl.financialspendanalyzerapp.service.OTPService;
import com.hcl.financialspendanalyzerapp.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

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
		if (findByCustomerId.isPresent()) {
			savedCustomer = findByCustomerId.get();
		} else {
			throw new ApplicationException("Invalid Customer id.");
		}
		transaction.setAmount(paymentDTO.getAmount());
		transaction.setCurrentBalance(savedCustomer.getAccountBalance());
		transaction.setCustomerDetails(savedCustomer);
		transaction.setDate(LocalDateTime.now());
		transaction.setPaymentType(paymentDTO.getPaymentType());
		transaction.setStatus("pending");
		transaction.setTransDescription(paymentDTO.getPaymentType());
		Transaction savedTransaction = transactionRepository.save(transaction);

		PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
		paymentResponseDTO.setCustomerId(paymentDTO.getCustomerId());
		paymentResponseDTO.setDate(savedTransaction.getDate());
		paymentResponseDTO.setPaymentType(savedTransaction.getPaymentType());
		paymentResponseDTO.setStatus(savedTransaction.getStatus());
		paymentResponseDTO.setTransactionAmount(savedTransaction.getAmount());
		paymentResponseDTO.setTransactionId(savedTransaction.getTransactionId());
		paymentResponseDTO.setTransDescription(savedTransaction.getTransDescription());

		oTPService.generateOTP(paymentDTO.getCustomerId(), savedTransaction.getTransactionId(), savedCustomer.getEmail() );
		responseDTO.setMessage("Payment transaction intitiated sucessfully.");
		responseDTO.setHttpStatus(HttpStatus.OK);
		responseDTO.setData(paymentResponseDTO);
		logger.debug("Payment transaction id : " + savedTransaction.getTransactionId());
		logger.info("Payment transaction intitiated");
		logger.info("" + responseDTO);

		return responseDTO;

	}

	@Override
	public ResponseDTO validateTransaction(OtpDTO otpDTO) throws ApplicationException {
	
		ResponseDTO responseDTO = new ResponseDTO();
		
		boolean validate = oTPService.validate(otpDTO.getCustomerId(), otpDTO.getTransactionId(), otpDTO.getOtpCode());
		if(BooleanUtils.isTrue(validate)) {
			Transaction completedTransaction = transactionRepository.findByTransactionIdAndStatusIgnoreCase(otpDTO.getTransactionId() , "pending");
			if(null == completedTransaction) {
				throw new ApplicationException("No transaction found");
			}
			Customer customerDetails = completedTransaction.getCustomerDetails();
			
			if("debit".equalsIgnoreCase(completedTransaction.getPaymentType())){
				if(customerDetails.getAccountBalance() < completedTransaction.getAmount()) {
					throw new ApplicationException("Insufficent balance");
				}else {
					customerDetails.setAccountBalance(customerDetails.getAccountBalance() - completedTransaction.getAmount());
					completedTransaction.setCurrentBalance(customerDetails.getAccountBalance() - completedTransaction.getAmount());
				}
			}else if("credit".equalsIgnoreCase(completedTransaction.getPaymentType())){
				customerDetails.setAccountBalance(customerDetails.getAccountBalance() + completedTransaction.getAmount());
				completedTransaction.setCurrentBalance(customerDetails.getAccountBalance() + completedTransaction.getAmount());
			}
			
			completedTransaction.setStatus("completed");
			Transaction savedTransaction = transactionRepository.save(completedTransaction);
			customerRepository.save(customerDetails);
			
			PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
			paymentResponseDTO.setCustomerId(otpDTO.getCustomerId());
			paymentResponseDTO.setDate(savedTransaction.getDate());
			paymentResponseDTO.setPaymentType(savedTransaction.getPaymentType());
			paymentResponseDTO.setStatus(savedTransaction.getStatus());
			paymentResponseDTO.setTransactionAmount(savedTransaction.getAmount());
			paymentResponseDTO.setTransactionId(savedTransaction.getTransactionId());
			paymentResponseDTO.setTransDescription(savedTransaction.getTransDescription());
			
			
			responseDTO.setMessage("Payment transaction completed sucessfully.");
			responseDTO.setHttpStatus(HttpStatus.OK);
			responseDTO.setData(paymentResponseDTO);
			logger.debug("Payment transaction id : " + savedTransaction.getTransactionId());
			logger.info("Payment transaction intitiated");
			logger.info("" + responseDTO);
			
		}else {
			throw new ApplicationException("Invalid input data");
		}
		
		return responseDTO;
	}

}
