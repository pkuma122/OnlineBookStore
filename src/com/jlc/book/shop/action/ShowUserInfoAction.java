package com.jlc.book.shop.action;

import java.util.List;

import javax.servlet.http.*;

import com.jlc.book.shop.delegate.OrderDelegate;
import com.jlc.book.shop.delegate.UserDelegate;
import com.jlc.book.shop.to.UserTO;

public class ShowUserInfoAction {

	public String getUserInfo(HttpServletRequest request, HttpServletResponse response) {
		String page="allOrdersDef.jsp";
		String userId=request.getParameter("userId");
		UserTO uto=UserDelegate.getUserInfoById(userId);
		request.setAttribute("USER_INFO", uto);
		List orderList=null;
		orderList=OrderDelegate.getAllOrderInfo();
		if(orderList!=null){
			request.setAttribute("ORDER_FOUND", orderList);
		}
		return page;
	}

}
