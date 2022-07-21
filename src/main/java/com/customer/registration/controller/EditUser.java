package com.customer.registration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.registration.model.UserDTO;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/edit")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int partyId=Integer.parseInt(request.getParameter("partyId"));
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
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
		user.setPassword(password);
		user.setAddress(address);
		user.setCity(city);
		user.setZip(zip);
		user.setState(state);
		user.setCountry(country);
		user.setPhone(phone);
			
		
	}

}
