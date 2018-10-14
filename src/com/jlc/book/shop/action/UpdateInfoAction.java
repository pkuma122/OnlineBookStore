package com.jlc.book.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlc.book.shop.delegate.UserDelegate;
import com.jlc.book.shop.to.UserTO;
import com.jlc.book.shop.validator.JLCDataValidator;

public class UpdateInfoAction {

	public String updateUserInfo(HttpServletRequest req, HttpServletResponse res) {
		boolean isError=false;
		String page="detailsDef.jsp";
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
	
		/* VALIDATING EMAIL */
		
		if(!JLCDataValidator.validateRequired(email)){
			req.setAttribute("email", "Email is Required ");
			isError=true;
		}else if(!JLCDataValidator.maxLength(email, 32)){
			req.setAttribute("email", "Email must be maximum 32 Character");
			isError=true;
		}else if(!JLCDataValidator.validateEmail(email)){
			req.setAttribute("email", "please enter valid email id");
			isError=true;
		}else if(UserDelegate.alreadyExistEmail(email)){
			req.setAttribute("email", "Email is already used.Please use different email");
			isError=true;
		}
	
        /* VALIDATING PHONE */
		
		if(!JLCDataValidator.validateRequired(phone)){
			req.setAttribute("phone", "phone is required");
			isError=true;
		}else if(!JLCDataValidator.validateLong(phone)){
			req.setAttribute("phone", "phone must be digits only");
			isError=true;
		}else if(!JLCDataValidator.minLength(phone,10) && JLCDataValidator.minLength(phone, 10)){
			req.setAttribute("phone", "phone must be 10 digits");
			isError=true;
		}else if(UserDelegate.alreadyExistPhone(phone)){
			req.setAttribute("phone", "Phone No is already registered.Please use different phone No");
			isError=true;
		}
		
		if(!isError){
			boolean updated=false;
			Object obj=req.getSession().getAttribute("USER_TO");
			UserTO uto=(UserTO)obj;
			updated=UserDelegate.updateUserInfo(uto.getUserId(),email,Long.parseLong(phone));
			if(updated){
				req.setAttribute("updateError", "Information updated Successfully");
				req.getSession().removeAttribute("EDIT_INFO");
				uto.setEmail(email);
				uto.setPhone(Long.parseLong(phone));
				req.getSession().setAttribute("USER_TO", uto);
			}else{
				req.setAttribute("updateError", "Error occured while updating the information. Please try later");	
			}
		}
		return page;
	}

}
