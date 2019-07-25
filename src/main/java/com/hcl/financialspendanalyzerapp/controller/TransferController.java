package com.hcl.financialspendanalyzerapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.financialspendanalyzerapp.dto.OtpDTO;
import com.hcl.financialspendanalyzerapp.dto.PaymentDTO;
import com.hcl.financialspendanalyzerapp.dto.ResponseDTO;
import com.hcl.financialspendanalyzerapp.exception.ApplicationException;
import com.hcl.financialspendanalyzerapp.service.TransferService;

@CrossOrigin
@RestController
@RequestMapping("/payment")
public class TransferController {

	private static final Logger logger = LoggerFactory.getLogger(TransferController.class);

	private static final String ERROR_MSG = "Mandetory Element missing : ";

	@Autowired
	TransferService transferService;

	@PostMapping("/initiate")
	public ResponseEntity<Object> initiateTransaction(@RequestBody PaymentDTO paymentDTO) throws ApplicationException {
		logger.info("Received Payment Request.");

		validatePaymentRequest(paymentDTO);
		logger.info("Sucessfully validated Payment Request.");

		ResponseDTO initiatTransactionResponse = transferService.initiatTransaction(paymentDTO);
		return new ResponseEntity<>(initiatTransactionResponse, HttpStatus.OK);
	}

	@PostMapping("/complete")
	public ResponseEntity<Object> validateTransaction(@RequestBody OtpDTO otpDTO) throws ApplicationException {

		validateOtpRequest(otpDTO);
		logger.info("Sucessfully validated Request.");
		ResponseDTO validateTransactionResponse =  transferService.validateTransaction(otpDTO);
		return new ResponseEntity<>(validateTransactionResponse, HttpStatus.OK);
	}

	private void validatePaymentRequest(PaymentDTO paymentDTO) throws ApplicationException {

		if (ObjectUtils.isEmpty(paymentDTO)) {
			throw new ApplicationException("Invalid request");
		}
		if (StringUtils.isEmpty(paymentDTO.getAmount())) {
			throw new ApplicationException(ERROR_MSG + "Amount");
		}
		if (StringUtils.isEmpty(paymentDTO.getCustomerId())) {
			throw new ApplicationException(ERROR_MSG + "Customer Id");
		}
		if (StringUtils.isEmpty(paymentDTO.getPaymentType())) {
			throw new ApplicationException(ERROR_MSG + "Payment Type");
		}

	}

	private void validateOtpRequest( OtpDTO otpDTO) throws ApplicationException {

		if (ObjectUtils.isEmpty(otpDTO)) {
			throw new ApplicationException("Invalid request");
		}
		if (StringUtils.isEmpty(otpDTO.getCustomerId())) {
			throw new ApplicationException(ERROR_MSG + "Customer Id");
		}
		if (StringUtils.isEmpty(otpDTO.getOtpCode())) {
			throw new ApplicationException(ERROR_MSG + "OtpCode");
		}
		if (StringUtils.isEmpty(otpDTO.getTransactionId())) {
			throw new ApplicationException(ERROR_MSG + "TransactionId()");
		}

	}
}
