package com.book.dao;

import java.util.ArrayList;

import com.book.entity.Book;

public interface BookDao {

	public String add(Book book);
	public ArrayList<Book> getAll();
	public String deleteBook(String bookId);
	public ArrayList<Book> searchBook(Book book);
	
}
