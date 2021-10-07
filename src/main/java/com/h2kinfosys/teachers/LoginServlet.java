package com.h2kinfosys.teachers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("Initialization Happens here");
	}
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String userName = req.getParameter("userID");
		String password = req.getParameter("password");
		System.out.println("Received User Id :: " + userName + " And Password " + password);
		
		ServletConfig config = getServletConfig();
		String value = config.getInitParameter("DBName");
		
		ServletContext context = getServletContext();
		
		context.setAttribute("DBName", value);
		
		PrintWriter out = resp.getWriter();
		
		/*
		 * req.getSession() - creates the session if not exists
		 * req.getSession(false) - controls creation
		 * req.getSession(true) - create
		 */
		
		HttpSession session = req.getSession();
		System.out.println("Session Creation " + session.getCreationTime());
		System.out.println("Session ID " + session.getId());
		session.setMaxInactiveInterval(120);
		
		String dispatcher = "index.jsp";
		Cookie cookieOne = null;
		session.setAttribute("errorMessage", "Invalid UserId or Password Provided");
		
		if(userName != null && 
				userName.trim().length() > 0 && 
				password != null && 
				password.trim().length() > 0) {
			if(password.equals(userName+"@123")) {
				out.println("<h1> Valid UserId and Password </h1>");
				
				dispatcher = "index.jsp";
				cookieOne = new Cookie("UserLoginFlag", "True");
			}else {
				dispatcher = "login.jsp";
				cookieOne = new Cookie("UserLoginFlag", "False");
			}
		}else {
			dispatcher = "login.jsp";
			cookieOne = new Cookie("UserLoginFlag", "False");
		}
		
		resp.addCookie(cookieOne);
		RequestDispatcher rd = req.getRequestDispatcher(dispatcher);
		rd.forward(req, resp);
		
	}

	
	@Override
	public void destroy() {
		System.out.println("Finalization Code here");
	}
}
