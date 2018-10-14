package com.jlc.book.shop.action;

import javax.servlet.http.*;
import com.jlc.book.shop.delegate.*;
import com.jlc.book.shop.to.UserTO;
import com.jlc.book.shop.validator.*;

public class LoginAction {

	public String verifyUser(HttpServletRequest req,HttpServletResponse res) {
	  String page="index.jsp";
	  String uname=req.getParameter("uname");
	  String pass=req.getParameter("pass");
	  boolean intractWithDB=true;
	  if(!JLCDataValidator.validateRequired(uname)){
		  req.setAttribute("uname", "Username is required");
		  intractWithDB=false;
	  }
	  if(!JLCDataValidator.validateRequired(pass)){
		  req.setAttribute("pass", "Password is required");
		  intractWithDB=false;
	  }
	  if(intractWithDB){
		  UserTO uto=UserDelegate.verifyUser(uname,pass);
		  if(uto!=null){
			  req.getSession().setAttribute("USER_TO", uto);
			  page="userHomeDef.jsp";
		  }else{
			  req.setAttribute("loginError", "Username or password is invalid");
		  }
	  }
		return page;
	}

}
