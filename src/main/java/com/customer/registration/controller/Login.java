package com.customer.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.registration.model.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserDAO userDAO=new UserDAO();
		try
		{
		RequestDispatcher dispatcher;
		UserDTO user=userDAO.getByUserIdAndPassword(email, password);
		if(user==null)
		{
			System.out.print("8888888888888");
			request.setAttribute("status", "failed");
			dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		HttpSession session=request.getSession();
		request.setAttribute("status", "success");
		session.setAttribute("Name", user.getFirstName());
		
		dispatcher=request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
		}catch(DAOException exception)
		{
			System.out.print("/////////////////////");
			
		}
		
		
		
		//		PrintWriter out= response.getWriter();
//		out.println(email+" "+password);
	}

}
