package com.h2kinfosys.teachers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet{
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("I am hitting doget method");
		PrintWriter out = resp.getWriter();
		
		Enumeration<String> headerNames = req.getHeaderNames();
		String headerName = null;
		while(headerNames.hasMoreElements()) {
			headerName = headerNames.nextElement();
			out.println("<p> Header Name :: " + headerName + " Header Value " + req.getHeader(headerName) + " </p>");
		}
		
		Enumeration<String> requestEnum = req.getParameterNames();
		String paramName = null;
		while(requestEnum.hasMoreElements()) {
			paramName = requestEnum.nextElement();
			out.println("<p> Param Name :: " + paramName + " Parameter Value " + req.getParameter(paramName) + " </p>");
		}
		
		Cookie[] cookies = req.getCookies();
		for (Cookie coo: cookies) {
			out.println("<p> Cookied Name :: " + coo.getName() + " Cookie Value " + coo.getValue());
		}
		
		
	}

}
