package com.customer.registration.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sendmail
 */
@WebServlet("/sendmail")
public class sendmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
		mail();
		}catch(AddressException ae)
		{
		System.out.println("address exception");
		System.out.println(ae);
		
		}catch(MessagingException me)
		{
			System.out.println("Message exception");
			System.out.println(me);
				
		}
		
		
	}
	private static void mail() throws AddressException, MessagingException
	{
		
		Properties prop = new Properties();
		 prop.put("mail.smtp.host", "smtp.gmail.com");
		    prop.put("mail.smtp.port", "587");
		    prop.put("mail.smtp.auth", "true");
		    prop.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(prop, new Authenticator() {
		    @Override
		    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
		        return new javax.mail.PasswordAuthentication("lavika355@gmail.com", "mqullycbudxlginz");
		    }
		});
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("lavika355@gmail.com"));
		message.setRecipients(
		  Message.RecipientType.TO, InternetAddress.parse("jayesh.bais6767@gmail.com"));
		message.setSubject("Mail Subject");
		System.out.println("1111");
		String msg = "This is my first email using JavaMailer";
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		message.setContent(multipart);
		Transport.send(message);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
