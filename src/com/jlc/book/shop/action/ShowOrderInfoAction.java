package com.jlc.book.shop.action;

import java.util.*;
import javax.servlet.http.*;
import com.jlc.book.shop.delegate.OrderDelegate;
import com.jlc.book.shop.to.*;

public class ShowOrderInfoAction {

	public String getOrderInfo(HttpServletRequest request, HttpServletResponse response) {
		String page=request.getParameter("page");
		String orderId=request.getParameter("orderId");
		OrderTO oto=OrderDelegate.getOrderByOrderId(orderId);
		request.setAttribute("ORDER_TO", oto);
		List orderList=null;
		if(page.equals("userOrderStatusDef.jsp")){
			Object obj=request.getSession().getAttribute("USER_TO");
			UserTO uto=(UserTO) obj;
			orderList=OrderDelegate.getOrderByUserId(uto.getUserId());
		}else{
			orderList=OrderDelegate.getAllOrderInfo();
		}
		if(orderList!=null){
			request.setAttribute("ORDER_FOUND", orderList);
		}
		return page;
	}

}
