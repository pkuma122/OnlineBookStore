package com.jlc.book.shop.factory;

import com.jlc.book.shop.dao.*;
import com.jlc.book.shop.dao.impl.*;

public class DAOFactory {
private static UserDAO userDAO=null;
private static BookDAO bookDAO=null;
private static OrderDAO orderDAO=null;
static{
  userDAO=new JDBCUserDAO();
  bookDAO=new JDBCBookDAO();
  orderDAO=new JDBCOrderDAO();
}
public static UserDAO getUserDAO(){
	return userDAO;
}
public static BookDAO getBookDAO(){
	return bookDAO;
}
public static OrderDAO getOrderDAO(){
	return orderDAO;
}

}
