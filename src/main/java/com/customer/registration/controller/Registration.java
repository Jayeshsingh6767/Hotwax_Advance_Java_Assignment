package com.customer.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;

import java.util.*;

import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.Message;
import javax.mail.MessagingException;

import com.customer.registration.model.*;


/**
 * Servlet implementation class Registration
 */
@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Extracting data from request
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		int zip=Integer.parseInt(request.getParameter("zip"));
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String phone=request.getParameter("phone");
		
		// create DTO and fill data
		UserDTO user= new UserDTO();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setAddress(address);
		user.setCity(city);
		user.setZip(zip);
		user.setState(state);
		user.setCountry(country);
		user.setPhone(phone);
		
		// create DAO object and add user
		UserDAO userDao=new UserDAO();
		RequestDispatcher dispatcher=request.getRequestDispatcher("registration.jsp");
		try {
			userDao.addUser(user);
			request.setAttribute("status", "success");
			//sendMail(email);
			dispatcher.forward(request, response);
			
				
			
		}catch(DAOException daoExceptio)
		{
			//System.out.println("ecdsjsdakgdsaklglkdsa");
			//PrintWriter out=response.getWriter();
			//out.println(daoExceptio.getMessage());
			//throw new ServletException(daoExceptio.getMessage());
			request.setAttribute("status", "failed");
			dispatcher.forward(request, response);
			
				
		}
		
	}
	

	
	
	private static void sendMail(String recipient)throws DAOException
	{
		try
		{
		Properties properties=new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		String myAccountEmail="lavika355@gmail.com";
	    String emailPassword="Jayshreeram@123";
		Session session=Session.getDefaultInstance(properties,new Authenticator() {
			@Override 
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(myAccountEmail,emailPassword);
					}
			
		});
		MimeMessage message=prepareMessage(session,myAccountEmail,recipient);
		System.out.println("54565454646");	
		Transport.send(message);
		System.out.println("Mail send Successfully");
		}catch(Exception e)
		{
			System.out.println("Exception aaya");
			System.out.println(e);
			
			throw new DAOException(e.getMessage());
		}
		
	}
	private static MimeMessage prepareMessage(Session session,String myAccountEmail,String recipient)
	{
		try {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(myAccountEmail));
		//message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(recipient));
		message.setSubject("Regarding your registration");
		message.setText("Congratulations your registration Succesful");
		return message;
		}catch(Exception exception)
		{
			System.out.println("prepare Message");
		}
		return null;
	}

}
