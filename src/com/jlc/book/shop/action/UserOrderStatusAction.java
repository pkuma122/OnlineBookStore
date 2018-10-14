package com.jlc.book.shop.action;

import java.util.*;
import javax.servlet.http.*;

import com.jlc.book.shop.delegate.OrderDelegate;
import com.jlc.book.shop.to.UserTO;

public class UserOrderStatusAction {

	public String getUserOrderStatus(HttpServletRequest request, HttpServletResponse response) {
         String page="userOrderStatusDef.jsp";
         Object obj=request.getSession().getAttribute("USER_TO");
         UserTO uto=(UserTO) obj;
         List orderList=OrderDelegate.getOrderByUserId(uto.getUserId());
         if(orderList!=null){
        	 request.setAttribute("ORDER_FOUND", orderList);
         }
		return page;
	}

}
