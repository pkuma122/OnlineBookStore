package com.jlc.book.shop.action;

import java.util.*;
import javax.servlet.http.*;
import com.jlc.book.shop.delegate.*;
import com.jlc.book.shop.to.*;

public class AddBookToCartAction {

	public String addBookToCart(HttpServletRequest request,	HttpServletResponse response) {
		String page="searchBookDef.jsp";
		String bid=request.getParameter("bookId");
		int bookId=Integer.parseInt(bid);
		HttpSession sess=request.getSession();
		Object obj=sess.getAttribute("SELECTED_BOOK_LIST");
		Set selectedBookList=null;
		BookTO bto=null;
		if(obj!=null){
			selectedBookList=(Set) obj;
			Iterator it=selectedBookList.iterator();
			boolean avail=false;
			while(it.hasNext()){
				BookTO bookTO=(BookTO) it.next();
				if(bookTO.getBookId()==bookId){
					bto=bookTO;
					avail=true;
					break;
				}
			}
		 if(!avail){
			 bto=BookDelegate.getBookById(bid);
		 }
		}else{
			selectedBookList=new HashSet();
			bto=BookDelegate.getBookById(bid);
		}
		bto.setSelectedNumberOfBook(bto.getSelectedNumberOfBook() + 1);
		request.setAttribute("ADDED_TO_CART_MESSAGE", "ADDED");
		request.setAttribute("ADDED_BOOK", bto);
		selectedBookList.add(bto);
		sess.setAttribute("SELECTED_BOOK_LIST", selectedBookList);
		return page;
	}

}
