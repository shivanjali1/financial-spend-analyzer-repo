package com.hcl.financialspendanalyzerapp.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.financialspendanalyzerapp.serviceimpl.EmailServiceImpl;

public class EmailUtil {
	
	@Autowired
	static EmailServiceImpl emailServiceImpl;

	
	public static void  sendEmail() {
		emailServiceImpl.sendSimpleMessage();
	}
	
}
