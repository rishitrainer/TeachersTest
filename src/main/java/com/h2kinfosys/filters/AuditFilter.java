package com.h2kinfosys.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;

public class AuditFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("AuditFilter Initi");
	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// Pre-processor
		System.out.println("IP Address of Client Machine :: " + req.getRemoteHost());
		// Chaining
		chain.doFilter(req, res);
		// Post Processor
		System.out.println("Response generated :: " + res.getContentType());
		
	}
 
}
