package com.customer.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.registration.model.UserDAO;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int partyId=Integer.parseInt(request.getParameter("id"));
		UserDAO userDAO = new UserDAO();
		userDAO.deleteUser(partyId);
		request.setAttribute("status", "delete");
		RequestDispatcher dispatcher=request.getRequestDispatcher("usersInfo.jsp");
		dispatcher.forward(request, response);
	
	}

}
