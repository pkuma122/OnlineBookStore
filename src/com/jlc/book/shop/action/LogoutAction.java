package com.jlc.book.shop.action;

import javax.servlet.http.*;

public class LogoutAction {
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		String page="index.jsp";
		request.getSession().invalidate();
		request.setAttribute("loginError", "You Have logged out successfully");
		return page;
	}

}
