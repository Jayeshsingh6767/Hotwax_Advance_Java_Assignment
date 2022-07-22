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
		RequestDispatcher dispatcher;
		HttpSession session=request.getSession();
		if(email.equals("jayesh.bais6767@gmail.com") && password.equals("123456"))
		{
			request.setAttribute("status", "success");
			session.setAttribute("Name", "Jayesh");
			dispatcher=request.getRequestDispatcher("usersInfo.jsp");
			dispatcher.forward(request, response);
			
			return;
		}
		UserDAO userDAO=new UserDAO();
		try
		{
		password=AES.encrypt(password);
		UserDTO user=userDAO.getByUserIdAndPassword(email, password);
		if(user==null)
		{
			request.setAttribute("status", "failed");
			dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
		request.setAttribute("status", "success");
		session.setAttribute("Name", user.getFirstName());
		
		dispatcher=request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
		}catch(Exception exception)
		{
			System.out.print(exception);
			
		}
		
		
		
		
		//		PrintWriter out= response.getWriter();
//		out.println(email+" "+password);
	}

}
