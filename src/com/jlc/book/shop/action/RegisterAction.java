package com.jlc.book.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlc.book.shop.delegate.UserDelegate;
import com.jlc.book.shop.to.UserTO;
import com.jlc.book.shop.validator.JLCDataValidator;

public class RegisterAction {

	public String registerStudent(HttpServletRequest req,HttpServletResponse res) {
		boolean isError=false;
		String page="registerDef.jsp";
		String fname=req.getParameter("fname");
		String mname=req.getParameter("mname");
		String lname=req.getParameter("lname");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String gender=req.getParameter("gender");
		String username=req.getParameter("uname");
		String password=req.getParameter("pass");
	/* VALIDATING FIRST NAME */	
		if(!JLCDataValidator.validateRequired(fname)){
			req.setAttribute("fname", "First name is required");
			isError=true;
		}else if(!JLCDataValidator.validateFirstCharacterAsUpper(fname)){
			req.setAttribute("fname", "First Name must be start with capital character");
			isError=true;
		}else if(!JLCDataValidator.minLength(fname,3)){
			req.setAttribute("fname", "First name must be minimum 3 character");
			isError=true;
		}else if(!JLCDataValidator.maxLength(fname,10)){
			req.setAttribute("fname", "First name must be maximum 10 character");
			isError=true;
		}else if(!JLCDataValidator.validateName(fname)){
			req.setAttribute("fname", "First Name must be only character");
			isError=true;
		}
		/* VALIDATING MIDDLE NAME */
		
		if(mname!=null && mname.length()>0){
		if(!JLCDataValidator.validateFirstCharacterAsUpper(mname)){
			req.setAttribute("mname", "Middle name must be start with capital character");
			isError=true;
		}else if(!JLCDataValidator.minLength(mname,1)){
			req.setAttribute("mname", "Middle name must be minimum 1 character");
			isError=true;
		}else if(!JLCDataValidator.maxLength(mname,10)){
			req.setAttribute("mname", "Middle name must be maximum 10 character");
			isError=true;
		}else if(!JLCDataValidator.validateName(mname)){
			req.setAttribute("mname", "Middle name must be only character");
			isError=true;
		}
	  }
		/* VALIDATING LAST NAME */	
		
		if(lname!=null && lname.length()>0){
		if(!JLCDataValidator.validateFirstCharacterAsUpper(lname)){
			req.setAttribute("lname", "last name must be start with capital character");
			isError=true;
		}else if(!JLCDataValidator.minLength(lname,3)){
			req.setAttribute("lname", "Last name must be minimum 3 character");
			isError=true;
		}else if(!JLCDataValidator.maxLength(lname,10)){
			req.setAttribute("lname", "Last name must be maximum 10 character");
			isError=true;
		}else if(!JLCDataValidator.validateName(lname)){
			req.setAttribute("lname", "Last name must be only character");
			isError=true;
		}
	  }else{
		  req.setAttribute("lname", "Last Name is required");
	  }
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
		
		/* VALIDATING GENDER */
		
		if(!JLCDataValidator.validateRequired(gender)){
			req.setAttribute("gender", "please select the gender");
			isError=true;
		}
       
		/* VALIDATING USERNAME */	
		
		if(!JLCDataValidator.validateRequired(username)){
			req.setAttribute("uname", "Username is required");
			isError=true;
		}else if(!JLCDataValidator.minLength(username,6)){
			req.setAttribute("uname", "Username name must be minimum 6 character long");
			isError=true;
		}else if(!JLCDataValidator.maxLength(username,8)){
			req.setAttribute("uname", "Username name must be maximum 8 character long");
			isError=true;
		}else if(UserDelegate.alreadyExist(username)){
			req.setAttribute("uname", "Username is already used.Please use different username");
			isError=true;
		}
		
        /* VALIDATING PASSWORD */	
		
		if(!JLCDataValidator.validateRequired(password)){
			req.setAttribute("pass", "Password is required");
			isError=true;
		}else if(!JLCDataValidator.minLength(password,6)){
			req.setAttribute("pass", "Password must be minimum 6 character long");
			isError=true;
		}else if(!JLCDataValidator.maxLength(password,15)){
			req.setAttribute("pass", "Password must be maximum 15 character long");
			isError=true;
		}
		
		if(!isError){
			boolean registered=false;
			UserTO uto=new UserTO(fname, mname, lname, email, Long.parseLong(phone), username, password, "User");
			registered=UserDelegate.registerUser(uto);
			if(registered){
				req.setAttribute("registrationError", "Registration Completes Successfully");
			}else{
				req.setAttribute("registrationError", "Error happened in registration. Please try later");	
			}
		}
		return page;
	}

}
