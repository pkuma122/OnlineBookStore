package com.jlc.book.shop.action;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.jlc.book.shop.delegate.UserDelegate;
import com.jlc.book.shop.to.UserTO;
import com.jlc.book.shop.validator.JLCDataValidator;

public class ChangePasswordAction {

	public String changePassword(HttpServletRequest req,HttpServletResponse res) {
		String page="changePasswordDef.jsp";
		String newpass=req.getParameter("newpass");
		String currpass=req.getParameter("currpass");
		String confpass=req.getParameter("confpass");
		
		boolean compareEquals=true;
		boolean intractWithDB=true;
		
		/* VALIDATING NEW PASSWORD */
		if(!JLCDataValidator.validateRequired(newpass)){
			req.setAttribute("newpass", "New Password is required");
			intractWithDB=false;
			compareEquals=false;
		}else if(!JLCDataValidator.minLength(newpass,6)){
			req.setAttribute("newpass", "New Password must be minimum 6 character long");
			intractWithDB=false;
			compareEquals=false;
		}else if(!JLCDataValidator.maxLength(newpass,15)){
			req.setAttribute("newpass", "New Password must be maximum 15 character long");
			intractWithDB=false;
			compareEquals=false;
		}
	/* VALIDATING CURRENT PASSWORD */
		if(!JLCDataValidator.validateRequired(currpass)){
			req.setAttribute("currpass", "Current Password is required");
			intractWithDB=false;
			compareEquals=false;
		}
	/* Validating CONFIRM Password */
		if(!JLCDataValidator.validateRequired(confpass)){
			req.setAttribute("confpass", "Confirm Password is required");
			intractWithDB=false;
			compareEquals=false;
		}else if(!JLCDataValidator.minLength(confpass,6)){
			req.setAttribute("confpass", "Confirm Password must be minimum 6 character long");
			intractWithDB=false;
			compareEquals=false;
		}else if(!JLCDataValidator.maxLength(confpass,15)){
			req.setAttribute("confpass", "Confirm Password must be maximum 15 character long");
			intractWithDB=false;
			compareEquals=false;
		}
	    if(compareEquals){
	    	 if(!newpass.equals(confpass)){
	    		 intractWithDB=false;
	    		 req.setAttribute("changePasswordError", "New & Confirm Password does not match");
	    	 }
	    }
	    if(intractWithDB){
	    	Object obj=req.getSession().getAttribute("USER_TO");
	    	UserTO usto=(UserTO) obj;
	    	if(currpass.equals(usto.getPassword())){
	    		UserTO uto=UserDelegate.changePassword(usto,newpass);
	    		if(uto!=null){
	    			req.getSession().setAttribute("USER_TO", uto);
	    			req.setAttribute("changePasswordError", "password updated successfully");
	    			req.setAttribute("CHANGED_PASSWORD", "OK");
	    		}else{
	    			req.setAttribute("changePasswordError", "Error in changing Password");
	    		}
	    	}else{
	    		req.setAttribute("changePasswordError", "Current password is invalid");
	    	}
	    }
		return page;
	}

	
}
