package com.jlc.book.shop.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlc.book.shop.action.*;

public class JLCBookShopServlet extends HttpServlet {
	LoginAction loginAction=null;
	LogoutAction logoutAction=null;
    ChangePasswordAction changePasswordAction=null;
    AddBookAction addBookAction=null;
    SearchBookAction searchBookAction=null;
    SortBookInfoAction sortBookInfoAction=null;
    ForgetPasswordAction forgetPasswordAction=null;
    RegisterAction registerAction=null;
    NextAction nextAction=null;
    PreviousAction previousAction=null;
    DeleteBookAction deleteBookAction=null;
    AddBookToCartAction addBookToCartAction=null;
    RemoveFromCartAction removeFromCartAction=null;
    PlaceOrderAction placeOrderAction=null;
    EditInfoAction editInfoAction=null;
    CancleEditInfoAction cancleEditInfoAction=null;
    UpdateInfoAction updateInfoAction=null;
    AllOrdersAction allOrdersAction=null;
    UserOrderStatusAction userOrderStatusAction=null;
    UpdateOrderStatusAction updateOrderStatusAction=null;
    ShowOrderInfoAction showOrderInfoAction=null;
    ShowUserInfoAction showUserInfoAction=null;
    
    public void init() throws ServletException {
       loginAction=new LoginAction();
       logoutAction=new LogoutAction();
       changePasswordAction=new ChangePasswordAction();
       addBookAction=new AddBookAction();
       searchBookAction=new SearchBookAction();
       sortBookInfoAction=new SortBookInfoAction();
       forgetPasswordAction=new ForgetPasswordAction();
       registerAction=new RegisterAction();
       nextAction=new NextAction();
       previousAction=new PreviousAction();
       deleteBookAction=new DeleteBookAction();
       addBookToCartAction=new AddBookToCartAction();
       removeFromCartAction=new RemoveFromCartAction();
       placeOrderAction=new PlaceOrderAction();
       editInfoAction=new EditInfoAction();
       cancleEditInfoAction=new CancleEditInfoAction();
       updateInfoAction=new UpdateInfoAction();
       allOrdersAction=new AllOrdersAction();
       userOrderStatusAction=new UserOrderStatusAction();
       updateOrderStatusAction=new UpdateOrderStatusAction();
       showOrderInfoAction=new ShowOrderInfoAction();
       showUserInfoAction=new ShowUserInfoAction();
	}
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String uri=request.getRequestURI();
      String page="";
      if(uri.endsWith("login.jlc")){
    	  page=loginAction.verifyUser(request,response);
      }else if(uri.endsWith("logout.jlc")){
    	  page=logoutAction.logout(request,response);
      }else if(uri.endsWith("changePassword.jlc")){
    	  page=changePasswordAction.changePassword(request,response);
      }else if(uri.endsWith("addBook.jlc")){
    	  page=addBookAction.addBookInfo(request,response);
      }else if(uri.endsWith("register.jlc")){
    	  page=registerAction.registerStudent(request,response);
      }else if(uri.endsWith("editinfo.jlc")){
    	  page=editInfoAction.makeEditable(request,response);
      }else if(uri.endsWith("cancleedit.jlc")){
    	  page=cancleEditInfoAction.cancleEditInfo(request,response);
      }else if(uri.endsWith("updateinfo.jlc")){
    	  page=updateInfoAction.updateUserInfo(request,response);
      }else if(uri.endsWith("forgetPassword.jlc")){
    	  page=forgetPasswordAction.searchPassword(request,response);
      }else if(uri.endsWith("placeorder.jlc")){
    	  page=placeOrderAction.placeOrder(request,response);
      }else if(uri.endsWith("searchBook.jlc")){
    	  page=searchBookAction.searchBookInfo(request,response);
      }else if(uri.endsWith("next.jlc")){
    	  page=nextAction.searchBookInfo(request,response);
      }else if(uri.endsWith("previous.jlc")){
    	  page=previousAction.searchBookInfo(request,response);
      }else if(uri.endsWith("delete.jlc")){
    	  page=deleteBookAction.deleteBook(request,response);
      }else if(uri.endsWith("addtocart.jlc")){
    	  page=addBookToCartAction.addBookToCart(request,response);
      }else if(uri.endsWith("sortInfo.jlc")){
    	  page=sortBookInfoAction.sortBookInfo(request,response);
      }else if(uri.endsWith("removefromcart.jlc")){
    	  page=removeFromCartAction.removeFromCart(request,response);
      }else if(uri.endsWith("allorders.jlc")){
    	  page=allOrdersAction.getAllOrders(request,response);
      }else if(uri.endsWith("userorderstatus.jlc")){
    	  page=userOrderStatusAction.getUserOrderStatus(request,response);
      }else if(uri.endsWith("updatestatus.jlc")){
    	  page=updateOrderStatusAction.updateOrderStatus(request,response);
      }else if(uri.endsWith("showorderinfo.jlc")){
    	  page=showOrderInfoAction.getOrderInfo(request,response);
      }else if(uri.endsWith("showuserinfo.jlc")){
    	  page=showUserInfoAction.getUserInfo(request,response);
      }
      
      request.getRequestDispatcher(page).forward(request, response);
    }
    public void destroy() {
		
	}



}
