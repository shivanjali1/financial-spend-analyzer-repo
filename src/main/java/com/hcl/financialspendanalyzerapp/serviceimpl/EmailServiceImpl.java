package com.hcl.financialspendanalyzerapp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {

	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendSimpleMessage() {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("kanaseshivanjali@gmail.com");
		simpleMailMessage.setSubject("spring boot simple mail msg");
		simpleMailMessage.setText("This is for testing .............\n spring boot simple mail msg");
		javaMailSender.send(simpleMailMessage);
	}
	
}
