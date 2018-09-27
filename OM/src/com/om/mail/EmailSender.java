package com.om.mail;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;
import java.util.*;
import java.io.*;

public class EmailSender {
	
	
	
	
	
	
	public static  void sendMail(String to , String message) throws AddressException, MessagingException
	
	{
		
		
		
		String host,from,password;
		
		from="aparnamalladi12@gmail.com";
		
		password="Aparna1234";
		host ="smtp.gmail.com";
		
		String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		
		String subject="Welcome Online Magazine";
		
		
		
		
		boolean sessionDebug = true;

		Properties props = System.getProperties();
		props.put("mail.host", host);
		props.put("mail.transport.protocol.", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		Session mailSession = Session.getDefaultInstance(props, null);
		mailSession.setDebug(sessionDebug);
		Message msg = new MimeMessage(mailSession);
		msg.setFrom(new InternetAddress(from));
		InternetAddress[] address = {new InternetAddress(to)};
		msg.setRecipients(Message.RecipientType.TO, address);
		msg.setSubject(subject);
		msg.setContent(message, "text/html"); // use setText if you want to send text
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(host, from, password);
		try {
		transport.sendMessage(msg, msg.getAllRecipients());
		//out.println("message successfully sended"); // assume it was sent

		}
		catch (Exception err) {

		System.out.println("message not successfully sended"); // assume it’s a fail
		}
		transport.close();

	}

}
