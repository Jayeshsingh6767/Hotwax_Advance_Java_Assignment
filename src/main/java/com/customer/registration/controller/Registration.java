package com.customer.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			dispatcher.forward(request, response);
			//System.out.println("\nsuccess");
		}catch(DAOException daoExceptio)
		{
			//PrintWriter out=response.getWriter();
			//out.println(daoExceptio.getMessage());
			
			request.setAttribute("status", "failed");
			dispatcher.forward(request, response);
				
		}
		
		
		
		
		
		
		
		
//		PrintWriter out=response.getWriter();
//		out.println(firstName);
//		out.println(lastName);
//		out.println(email);
//		out.println(password);
//		out.println(address);
//		out.println(city);
//		out.println(zip);
//		out.println(state);
//		out.println(country);
//		out.println(phone);
		
		

		
	}

}
