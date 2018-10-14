package com.jlc.book.shop.dao;

import java.util.List;
import com.jlc.book.shop.to.*;

public interface BookDAO {
public boolean addBook(BookTO bto);
public boolean alreadyExist(BookTO bto);
public List searchBook(BookTO bto, int start, int numberOfBook);
public int getTotalNumberOfBook(BookTO bto);
public boolean deleteBook(int bookId);
public BookTO getBookById(String bid);
}
