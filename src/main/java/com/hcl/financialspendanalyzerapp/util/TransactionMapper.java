package com.hcl.financialspendanalyzerapp.util;

import com.hcl.financialspendanalyzerapp.dto.TransactionDTO;
import com.hcl.financialspendanalyzerapp.entity.Transaction;

public class TransactionMapper {

		
		public static TransactionDTO mapTransactionDTOToResponseList(Transaction t) {
			TransactionDTO transactionDTO = new TransactionDTO();
			transactionDTO.setAmount(t.getAmount());
			transactionDTO.setCurrentBalance(t.getCurrentBalance());
			transactionDTO.setDate(t.getDate());
			transactionDTO.setPaymentType(t.getPaymentType());
			transactionDTO.setTransDescription(t.getTransDescription());
			return transactionDTO;
			
		}

	}

