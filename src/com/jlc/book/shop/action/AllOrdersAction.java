package com.jlc.book.shop.action;

import java.util.List;

import javax.servlet.http.*;

import com.jlc.book.shop.delegate.OrderDelegate;

public class AllOrdersAction {

	public String getAllOrders(HttpServletRequest req, HttpServletResponse res) {
       	String page="allOrdersDef.jsp";
       	List orderList=OrderDelegate.getAllOrderInfo();
       	if(orderList!=null){
       		req.setAttribute("ORDER_FOUND", orderList);
       	}
		return page;
	}

}
