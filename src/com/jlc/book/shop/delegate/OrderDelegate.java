package com.jlc.book.shop.delegate;

import java.util.List;

import com.jlc.book.shop.dao.OrderDAO;
import com.jlc.book.shop.factory.DAOFactory;
import com.jlc.book.shop.to.OrderTO;

public class OrderDelegate {
private static OrderDAO orderDAO=null;
static{
	orderDAO=DAOFactory.getOrderDAO();
}
public static String placeOrder(OrderTO oto,String ip){
	return orderDAO.placeOrder(oto, ip);
}
public static List getOrderByUserId(String userId){
	return orderDAO.getOrderByUserId(userId);
}
public static List getAllOrderInfo(){
	return orderDAO.getAllOrderInfo();
}
public static void updateStatus(String orderId,String status){
	 orderDAO.updateStatus(orderId, status);
}
public static OrderTO getOrderByOrderId(String OrderId){
	return orderDAO.getOrderByOrderId(OrderId);
}

}
