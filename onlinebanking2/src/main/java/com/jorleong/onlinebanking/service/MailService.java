package com.jorleong.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
//	@Autowired
//	SimpleMailMessage simpleMailMessage;
	
	public void sendMail(String mailTo, String subject, String body) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setTo(mailTo);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(body);
		mailSender.send(simpleMailMessage);
		
	}
}
