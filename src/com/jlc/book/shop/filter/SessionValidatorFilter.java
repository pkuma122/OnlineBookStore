package com.jlc.book.shop.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionValidatorFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
     HttpServletRequest hReq=(HttpServletRequest) req;
     String uri=hReq.getRequestURI();
     if(uri.endsWith("login.jlc")|| uri.endsWith("register.jlc")|| uri.endsWith("forgetPassword.jlc")){
    	 chain.doFilter(req, res);
     }
     else{
    	 HttpSession sess=hReq.getSession(false);
    	 if(sess==null){
    		 req.setAttribute("loginError", "Session timeout. Please login again");
    		 req.getRequestDispatcher("index.jsp").forward(req, res);
    	 }else{
    		 chain.doFilter(req, res);
    	 }
     }
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
	public void destroy() {
	}



}
