package com.customer.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.registration.model.DAOException;
import com.customer.registration.model.UserDAO;
import com.customer.registration.model.UserDTO;

/**
 * Servlet implementation class EditUserForm
 */
@WebServlet("/editUserForm")
public class EditUserForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    		doPost(request, response);
    	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int partyId=Integer.parseInt(request.getParameter("id"));
		UserDAO userDAO=new UserDAO();
		try
		{
		RequestDispatcher dispatcher;
		UserDTO user=userDAO.getByPartyId(partyId);
		if(user==null)
		{
			request.setAttribute("status", "failed");
			dispatcher=request.getRequestDispatcher("search.jsp");
			dispatcher.forward(request, response);
		}
		request.setAttribute("partyId", user.getPartyid());
		request.setAttribute("firstName", user.getFirstName());
		request.setAttribute("lastName", user.getLastName());
		request.setAttribute("address", user.getAddress());
		request.setAttribute("city", user.getCity());
		request.setAttribute("zip", String.valueOf(user.getZip()));
		request.setAttribute("state", user.getState());
		request.setAttribute("country", user.getCountry());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("phone", user.getPhone());
		dispatcher=request.getRequestDispatcher("showUserDetailsForEdit.jsp");
		dispatcher.forward(request, response);
		
		}catch(DAOException exception)
		{
			System.out.print("/////////////////////");
			
		}
	
	}

}
