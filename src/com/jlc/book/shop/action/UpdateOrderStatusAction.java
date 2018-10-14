package com.jlc.book.shop.action;

import java.util.List;

import javax.servlet.http.*;

import com.jlc.book.shop.delegate.OrderDelegate;

public class UpdateOrderStatusAction {

	public String updateOrderStatus(HttpServletRequest request,	HttpServletResponse response) {
	   String page="allOrdersDef.jsp";
	   String orderId=request.getParameter("orderId");
	   String status=request.getParameter("status");
	   OrderDelegate.updateStatus(orderId, status);
	   List orderList=OrderDelegate.getAllOrderInfo();
	   if(orderList!=null){
		   request.setAttribute("ORDER_FOUND", orderList);
	   }
		return page;
	}

}
