package com.customer.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.registration.model.DAOException;
import com.customer.registration.model.UserDAO;
import com.customer.registration.model.UserDTO;

/**
 * Servlet implementation class SearchForm
 */
@WebServlet("/search")
public class SearchForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		UserDAO userDAO=new UserDAO();
		try
		{
		RequestDispatcher dispatcher;
		UserDTO user=userDAO.getByName(firstName, lastName);
		if(user==null)
		{
			request.setAttribute("status", "failed");
			dispatcher=request.getRequestDispatcher("search.jsp");
			dispatcher.forward(request, response);
		}
		
		request.setAttribute("firstName", user.getFirstName());
		request.setAttribute("lastName", user.getLastName());
		request.setAttribute("address", user.getAddress());
		request.setAttribute("city", user.getCity());
		request.setAttribute("zip", String.valueOf(user.getZip()));
		request.setAttribute("state", user.getState());
		request.setAttribute("country", user.getCountry());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("phone", user.getPhone());
		dispatcher=request.getRequestDispatcher("showUserDetails.jsp");
		dispatcher.forward(request, response);
		
		}catch(DAOException exception)
		{
			System.out.print("/////////////////////");
			
		}
		
	}

}
