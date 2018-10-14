package com.jlc.book.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CancleEditInfoAction {

	public String cancleEditInfo(HttpServletRequest req,HttpServletResponse res) {
		String page="detailsDef.jsp";
		req.getSession().removeAttribute("EDIT_INFO");
		return page;
	}

}
