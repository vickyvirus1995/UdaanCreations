package com.vickyvirus.udaan.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class SendMail {
	
	public static boolean sendMail(String fromEmail,String mobileNo,String enquiryMessage,String name)
	{
		String username = "udaancreations20@gmail.com";
		String password = "udaan2020";
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String message = "\n Name : "+name +"\n Email : "+ fromEmail+
		"\n Mobile Number : " + mobileNo + "\n Enquiry Message : "+ enquiryMessage;


		Session session_mail = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});

		MimeMessage msg = new MimeMessage(session_mail);
		try {
			msg.setFrom(new InternetAddress(username));
			
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress("rnas_udaancreations@yahoo.com"));
				msg.setSubject("Udaan Creation Enquiry");
				msg.setText(message);
			Transport.send(msg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 	
		return false;
	}
	
}


