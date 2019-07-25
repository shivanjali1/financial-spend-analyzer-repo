package com.hcl.financialspendanalyzerapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class TransferController {

	@RequestMapping("")
	public ResponseEntity<Object> initiateTransaction(){
		return null;
	}
	
}
