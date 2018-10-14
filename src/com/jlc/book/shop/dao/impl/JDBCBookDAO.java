package com.jlc.book.shop.dao.impl;

import java.sql.*;
import java.util.*;
import org.apache.log4j.*;
import com.jlc.book.shop.dao.*;
import com.jlc.book.shop.to.*;
import com.jlc.book.shop.util.*;

public class JDBCBookDAO implements BookDAO {
Logger log=Logger.getLogger(this.getClass());	
public boolean addBook(BookTO bto) {
	   boolean added=false;
	   Connection con=null;
	   PreparedStatement ps=null;
	   ResultSet rs=null;
				try {
					 con=JDBCUtil.getConnection();
					 String sql="insert into book_table (bookName,author,cost,publication,edition) values(?,?,?,?,?)";
					 ps=con.prepareStatement(sql);
					 ps.setString(1, bto.getBookName());
					 ps.setString(2, bto.getAuthor());
					 ps.setFloat(3, bto.getCost());
					 ps.setString(4, bto.getPublication());
					 ps.setString(5, bto.getEdition());
					 int x=ps.executeUpdate();
           			 if(x>0){
						 added=true;
					 }
				}catch(Exception e){
					added=false;
					log.error("Exception in addBook:\n",e);
				}finally{
					JDBCUtil.close(rs, ps, con);
				}
	return added;
}
public boolean deleteBook(int bookId) {
		log.info(bookId + "");
		boolean deleted=false;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement("delete from book_table where bookId=?");
			ps.setInt(1, bookId);
			int x=ps.executeUpdate();
			if(x > 0){
				deleted=true;
			}
		} catch (Exception e) {
			deleted=false;
			log.error("Exception in deleteBook:\n", e);
		}finally{
			JDBCUtil.close(null, ps, con);
		}
		return deleted;
	}
public boolean alreadyExist(BookTO bto) {
	boolean exist=false;
	   Connection con=null;
	   PreparedStatement ps=null;
	   ResultSet rs=null;
				try {
					 con=JDBCUtil.getConnection();
					 String sql="select * from book_table where bookName=? and author=? and cost=? and publication=? and edition=?";
					 ps=con.prepareStatement(sql);
					 ps.setString(1, bto.getBookName());
					 ps.setString(2, bto.getAuthor());
					 ps.setFloat(3, bto.getCost());
					 ps.setString(4, bto.getPublication());
					 ps.setString(5, bto.getEdition());
					 rs=ps.executeQuery();
					 if(rs.next()){
					   exist=true; 	 
					 }
				 }catch(Exception e){
		          exist=false;;
		          log.error("Exception in alreadyExist:\n", e);
		         }finally{
		        	JDBCUtil.close(rs, ps, con); 
		         }
		return exist;
	}
public BookTO getBookById(String bid) {
		BookTO bto=null;
	    Connection con=null;
	    PreparedStatement ps=null;
	    ResultSet rs=null;
	  try {
		   con=JDBCUtil.getConnection();
		  ps=con.prepareStatement("select * from book_table where bookId=?");
		  ps.setInt(1, Integer.parseInt(bid));
		  rs=ps.executeQuery();
		  if(rs.next()){
			  bto=new BookTO();
			  bto.setBookId(rs.getInt(1));
			  bto.setBookName(rs.getString(2));
			  bto.setAuthor(rs.getString(3));
			  bto.setCost(rs.getFloat("cost"));
			  bto.setPublication(rs.getString("publication"));
			  bto.setEdition(rs.getString("edition"));
		  }
	} catch (Exception e) {
		bto=null;
		log.error("Exception in getBookById:\n", e);
	}finally{
		JDBCUtil.close(rs, ps, con);
	}
		return bto;
	}
public int getTotalNumberOfBook(BookTO bto) {
		int total=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(prepareQuery(bto));
			int i=1;
			if(bto.getBookName()!=null && bto.getBookName().length()!=0)
			     ps.setString(i++, "%" + bto.getBookName().trim() + "%");
			 if(bto.getCost()!=0)
				 ps.setFloat(i++, bto.getCost());
			 if(bto.getAuthor()!=null && bto.getAuthor().length()!=0)
				 ps.setString(i++, "%" + bto.getAuthor().trim() + "%");
			 if(bto.getPublication()!=null && bto.getPublication().length()!=0)
				 ps.setString(i++, "%" + bto.getPublication().trim() + "%");
			 if(bto.getEdition()!=null && bto.getEdition().length()!=0)
				 ps.setString(i++, bto.getEdition().trim());
			 rs=ps.executeQuery();
			 while(rs.next()){
				total++; 
			 }
		} catch (Exception e) {
			log.error("Exception in getTotalNoOfBook:\n", e);
		}finally{
		  JDBCUtil.close(rs, ps, con);	
		}
	   return total;
	}
public List searchBook(BookTO bto, int start, int numberOfBook) {
		List bookList=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(prepareQuery(bto),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			int i=1;
			if(bto.getBookName()!=null && bto.getBookName().length()!=0)
			     ps.setString(i++, "%" + bto.getBookName().trim() + "%");
			 if(bto.getCost()!=0)
				 ps.setFloat(i++, bto.getCost());
			 if(bto.getAuthor()!=null && bto.getAuthor().length()!=0)
				 ps.setString(i++, "%" + bto.getAuthor().trim() + "%");
			 if(bto.getPublication()!=null && bto.getPublication().length()!=0)
				 ps.setString(i++, "%" + bto.getPublication().trim() + "%");
			 if(bto.getEdition()!=null && bto.getEdition().length()!=0)
				 ps.setString(i++, bto.getEdition().trim());
			 rs=ps.executeQuery();
			 rs.absolute(start + 1);
			 int x=1;
			 bookList=new ArrayList();
			 do{
				 BookTO bookTO=new BookTO(rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6), rs.getFloat(4));
				 bookTO.setBookId(rs.getInt(1));
				 bookList.add(bookTO);
				 x++;
			 }while(rs.next() && x<=numberOfBook);
		} catch (Exception e) {
			bookList=null;
			log.error("Exception in searchBook:\n", e);
		}finally{
		  JDBCUtil.close(rs, ps, con);	
		}
		return bookList;
	}
private String prepareQuery(BookTO bto) {
	String qry="select * from book_table";
	boolean whereAdded=false;
	if(bto.getBookName()!=null && bto.getBookName().length()!=0){
		qry+=" where bookName like ?";
		whereAdded=true;
	}
	if(bto.getCost()!=0){
		if(whereAdded){
			qry +=" and cost=? ";
		}else{
			qry +=" where cost=? ";
			whereAdded=true;
		}
	}
    if(bto.getAuthor()!=null && bto.getAuthor().length()!=0){
    	if(whereAdded){
    		qry+=" and author like ?";
    	}else{
    		qry+=" where author like ?";
    		whereAdded=true;
    	}
    }
    if(bto.getPublication()!=null && bto.getPublication().length()!=0){
    	if(whereAdded){
    		qry+=" and publication like ?";
    	}else{
    		qry+=" where publication like ?";
    		whereAdded=true;
    	}
    }
    if(bto.getEdition()!=null && bto.getEdition().length()!=0){
    	if(whereAdded){
    		qry+=" and edition=?";
    	}else{
    		qry+=" where edition=?";
    		whereAdded=true;
    	}
    }
	return qry;
}
}
