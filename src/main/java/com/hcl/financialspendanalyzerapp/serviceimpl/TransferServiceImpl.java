package com.hcl.financialspendanalyzerapp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.financialspendanalyzerapp.repository.CustomerRepository;

@Service
public class TransferServiceImpl {
	
	@Autowired
	CustomerRepository customerRepository;

}
