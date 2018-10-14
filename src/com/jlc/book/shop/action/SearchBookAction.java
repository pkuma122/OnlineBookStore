package com.jlc.book.shop.action;

import java.util.*;
import javax.servlet.http.*;
import com.jlc.book.shop.delegate.*;
import com.jlc.book.shop.to.*;
import com.jlc.book.shop.util.*;

public class SearchBookAction {

	public String searchBookInfo(HttpServletRequest request, HttpServletResponse response) {
		String page="searchBookDef.jsp";
		String bnm=request.getParameter("bname");
		String author=request.getParameter("author");
		String cost=request.getParameter("cost");
		String pub=request.getParameter("publication");
		String edi=request.getParameter("edition");
		float bcost=0.0f;
		if(cost!=null && cost.length()!=0)
			try {
				bcost=Float.parseFloat(cost);
			} catch (NumberFormatException e) {
				request.setAttribute("searchingBookError", "provide only Digits as Cost");
				request.getSession().removeAttribute("BOOK_LIST");
				return page;
				
			}
			BookTO bto=new BookTO(bnm, author, pub, edi, bcost);
			int start=0;
			int noBook=BookUtil.NUMBER_OF_BOOK;
			int total=BookDelegate.getTotalNumberOfBook(bto);
			List bookList=BookDelegate.searchBook(bto,start,noBook);
			HttpSession sess=request.getSession();
			sess.setAttribute("BOOK_NAME", bnm);
			sess.setAttribute("AUTHOR", author);
			sess.setAttribute("PUBLICATION", pub);
			sess.setAttribute("EDITION", edi);
			sess.setAttribute("START", new Integer(start));
			int end=start+noBook;
			if(total<=end){
				end=total;
			}
			sess.setAttribute("END", new Integer(end));
			sess.setAttribute("TOTAL", new Integer(total));
			if(bcost!=0){
				sess.setAttribute("COST", new Float(bcost));
			}else{
				sess.setAttribute("COST", "");
			}
			if(bookList==null){
				request.setAttribute("searchingBookError", "No Book found with specified information");
				sess.removeAttribute("BOOK_LIST");
			}else{
				sess.setAttribute("BOOK_LIST", bookList);
			}
			
			
		return page;
	}

}
