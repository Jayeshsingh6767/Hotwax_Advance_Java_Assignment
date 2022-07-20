package com.helloWorldFromServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="HelloWorldServlet" , value="/Welcome")
public class HelloWorldServlet extends HttpServlet{
	public void service(HttpServletRequest req , HttpServletResponse res) throws IOException
	{
		
		PrintWriter p= res.getWriter();
		p.print("Hello World");
		
	}
	}
