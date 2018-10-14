package com.jlc.book.shop.action;

import java.util.*;
import javax.servlet.http.*;
import com.jlc.book.shop.delegate.*;
import com.jlc.book.shop.to.*;
import com.jlc.book.shop.util.*;
import com.jlc.book.shop.validator.*;

public class PlaceOrderAction {

	public String placeOrder(HttpServletRequest req,HttpServletResponse res){
	  String page="placeOrderDef.jsp";
	  boolean isError=false;
	  String address=req.getParameter("address");
	  String street=req.getParameter("street");
	  String city=req.getParameter("city");
	  String state=req.getParameter("state");
	  String country=req.getParameter("country");
	  String zip=req.getParameter("zip");
	  String cardNo=req.getParameter("cardNo");
	  String pin=req.getParameter("pin");
	  String cardExp=req.getParameter("cardExp");
	  
	  /* VALIDATING ADDRESS */
	  
	  if(!JLCDataValidator.validateRequired(address)){
	      req.setAttribute("address", "Address is Required");
	      isError=true;
	  }else if(!JLCDataValidator.minLength(address, 3)){
		  req.setAttribute("address", "Address must be minimum 3 character");
		  isError=true;
	  }else if(!JLCDataValidator.maxLength(address, 25)){
		  req.setAttribute("address", "Address must be maximum 25 character");
		  isError=true;
	  }
	  
     /* VALIDATING STREET */
	  
	  if(!JLCDataValidator.validateRequired(street)){
	      req.setAttribute("street", "Street is Required");
	      isError=true;
	  }else if(!JLCDataValidator.minLength(street, 3)){
		  req.setAttribute("street", "Street must be minimum 3 character");
		  isError=true;
	  }else if(!JLCDataValidator.maxLength(street, 30)){
		  req.setAttribute("street", "Street must be maximum 30 character");
		  isError=true;
	  }
	  
       /* VALIDATING CITY */
	  
	  if(!JLCDataValidator.validateRequired(city)){
	      req.setAttribute("city", "City is Required");
	      isError=true;
	  }else if(!JLCDataValidator.minLength(city, 3)){
		  req.setAttribute("city", "City must be minimum 3 character");
		  isError=true;
	  }else if(!JLCDataValidator.maxLength(city, 30)){
		  req.setAttribute("city", "City must be maximum 30 character");
		  isError=true;
	  }
	 
      /* VALIDATING STATE */
	  
	  if(!JLCDataValidator.validateRequired(state)){
	      req.setAttribute("state", "State is Required");
	      isError=true;
	  }else if(!JLCDataValidator.minLength(state, 2)){
		  req.setAttribute("state", "State must be minimum 2 character");
		  isError=true;
	  }else if(!JLCDataValidator.maxLength(state, 20)){
		  req.setAttribute("state", "State must be maximum 20 character");
		  isError=true;
	  }
	 
       /* VALIDATING COUNTRY */
	  
	  if(!JLCDataValidator.validateRequired(country)){
	      req.setAttribute("country", "Country is Required");
	      isError=true;
	  }else if(!JLCDataValidator.minLength(country, 2)){
		  req.setAttribute("country", "Country must be minimum 2 character");
		  isError=true;
	  }else if(!JLCDataValidator.maxLength(country, 20)){
		  req.setAttribute("country", "Country must be maximum 20 character");
		  isError=true;
	  }
	  
       /* VALIDATING  ZIP*/
	  
	  if(!JLCDataValidator.validateRequired(zip)){
	      req.setAttribute("zip", "Zip is Required");
	      isError=true;
	  }else if(!JLCDataValidator.validateLong(zip)){
		  req.setAttribute("zip", "Zip must be digits only");
		  isError=true;
	  }else if(!JLCDataValidator.minLength(zip, 6)){
		  req.setAttribute("zip", "Zip must be 6 digits");
		  isError=true;
	  }else if(!JLCDataValidator.maxLength(zip, 6)){
		  req.setAttribute("zip", "Zip must be 6 digits");
		  isError=true;
	  }

       /* VALIDATING  CARD NUMBER*/
	  
	  if(!JLCDataValidator.validateRequired(cardNo)){
	      req.setAttribute("cardNo", "Card No is Required");
	      isError=true;
	  }else if(!JLCDataValidator.validateLong(cardNo)){
		  req.setAttribute("cardNo", "Card NO must be digits only");
		  isError=true;
	  }else if(!JLCDataValidator.minLength(cardNo, 16)){
		  req.setAttribute("cardNo", "Card No must be 16 digits");
		  isError=true;
	  }else if(!JLCDataValidator.maxLength(cardNo, 16)){
		  req.setAttribute("cardNo", "Card No must be 16 digits");
		  isError=true;
	  }
	  
       /* VALIDATING  SECRET PIN*/
	  
	  if(!JLCDataValidator.validateRequired(pin)){
	      req.setAttribute("pin", "Secret pin is Required");
	      isError=true;
	  }else if(!JLCDataValidator.validateLong(cardNo)){
		  req.setAttribute("pin", "Secret pin must be digits only");
		  isError=true;
	  }else if(!JLCDataValidator.minLength(pin, 4)){
		  req.setAttribute("pin", "Secret pin must be 4 digits");
		  isError=true;
	  }else if(!JLCDataValidator.maxLength(pin, 4)){
		  req.setAttribute("pin", "Secret pin must be 4 digits");
		  isError=true;
	  }

       /* VALIDATING  EXPIRY DATE*/
	  
	  if(!JLCDataValidator.validateRequired(cardExp)){
	      req.setAttribute("cardExp", "Expiry date is Required");
	      isError=true;
	  }else if(!JLCDataValidator.minLength(cardExp, 6)){
		  req.setAttribute("cardExp", "Not a valid expiry date");
		  isError=true;
	  }else if(!JLCDataValidator.maxLength(cardExp, 7)){
		  req.setAttribute("cardExp", "Not a valid expiry date");
		  isError=true;
	  }else if(!JLCDataValidator.validateExpDate(cardExp)){
		  req.setAttribute("cardExp", "Not a valid expiry date");
		  isError=true;  		  
	  }
	  
	  if(!isError){
		  String orderDate=Calendar.getInstance().get(Calendar.DATE)+"/"+
		                   (Calendar.getInstance().get(Calendar.MONTH)+1)+"/"+Calendar.getInstance().get(Calendar.YEAR);
		  Set orderItemList=(Set)req.getSession().getAttribute("SELECTED_BOOK_LIST");
		  float totalAmount=0.0f;
		  int totalItem=0;
		  Object obj=req.getSession().getAttribute("TOTAL_BOOK_QUANTITY");
		  if(obj!=null){
			  Integer i=(Integer) obj;
			  totalItem=i.intValue();
		  }
		  obj=req.getSession().getAttribute("TOTAL_BOOK_AMOUNT");
		  if(obj!=null){
			  Double d=(Double)obj;
			  totalAmount=Float.parseFloat(GetTotalAmount.getTotalAmount(d.toString()));
		  }
	   UserTO userTo=(UserTO) req.getSession().getAttribute("USER_TO");
	   OrderTO oto=new OrderTO();
	   oto.setAddress(address);
	   oto.setCardNo(cardNo);
	   oto.setCity(city);
	   oto.setCountry(country);
	   oto.setUserId(userTo.getUserId());
	   oto.setExpDate(cardExp);
	   oto.setOrderDate(orderDate);
	   oto.setOrderItemList(orderItemList);
	   oto.setState(state);
	   oto.setStreet(street);
	   oto.setTotalAmount(totalAmount);
	   oto.setTotalItem(totalItem);
	   oto.setZip(zip);
	   String orderId=OrderDelegate.placeOrder(oto, req.getRemoteAddr());
	   if(orderId!=null){
		   req.setAttribute("ORDER_PLACED", orderId);
		   HttpSession sess=req.getSession();
		   sess.removeAttribute("TOTAL_BOOK_AMOUNT");
		   sess.removeAttribute("TOTAL_BOOK_QUANTITY");
	   }else{
		  req.setAttribute("errorInOrder", "Error occured while placing order. Please try later");
	  }
	}
	  return page;
	}

}
