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
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;

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
			try
			{
			mail(email,firstName);
			}catch(AddressException ae)
			{
			System.out.println("address exception");
			System.out.println(ae);
			
			}catch(MessagingException me)
			{
				System.out.println("Message exception");
				System.out.println(me);
					
			}
			request.setAttribute("status", "success");
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
	

	private static void mail(String userEmail,String userName) throws AddressException, MessagingException
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
		  Message.RecipientType.TO, InternetAddress.parse(userEmail));
		message.setSubject("Regarding Registration");
		String msg = "Congratulations!\n	Hello "+userName+" your registered successfully use your "+userEmail+" for login";
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		message.setContent(multipart);
		Transport.send(message);
		
	}

}
