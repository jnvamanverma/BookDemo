package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.book.dao.BookDao;
import com.book.entity.Book;
import com.db.util.DBUtil;

public class BookDaoImpl implements BookDao {

	Connection connection;

	public BookDaoImpl() {
		DBUtil dbUtil = new DBUtil();
		connection = dbUtil.getConnection();
	}

	@Override
	public String add(Book book) {
		String result = "FAIL";

		String sql = "INSERT INTO IEC_BOOK VALUES(?,?,?)";

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, book.getBookId());
			ps.setString(2, book.getBookName());
			ps.setDouble(3, book.getBookPrice());

			int res = ps.executeUpdate();

			if (res > 0) {
				result = "ROW INSERTED";
			}

		} catch (SQLException e) {
			System.out.println("INSERT ERROR..." + e);
		}

		return result;
	}

	@Override
	public ArrayList<Book> getAll() {

		ArrayList<Book> list = new ArrayList<Book>();

		String sql = "SELECT * FROM IEC_BOOK";
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				Double price = rs.getDouble(3);

				Book b = new Book(id, name, price);
				list.add(b);
			}

		} catch (SQLException e) {
			System.out.println("error in loading rows");
		}

		return list;
	}

	@Override
	public ArrayList<Book> searchBook(Book book) {
		ArrayList<Book> list = new ArrayList<Book>();

		String sql = "SELECT * FROM IEC_BOOK where ", p = "";
		PreparedStatement ps = null;
		try {

			if (!book.getBookId().isEmpty()) {
				p = p + "book_id" + "=" + "'" + book.getBookId() + "'";
				sql += p;

			} else if (!book.getBookName().isEmpty()) {
				p = p + "book_name" + "=" + "'" + book.getBookName() + "'";
				sql += p;
			} else if (book.getBookPrice() > 0) {
				p = p + "book_price" + "=" + book.getBookPrice();
				sql += p;
			}

			if (p.length() > 0) {
				ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				System.out.println(sql);

				while (rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					Double price = rs.getDouble(3);

					Book b = new Book(id, name, price);
					list.add(b);
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public String deleteBook(String bookId) {
		String sql = "DELETE * FROM IEC_BOOK WHERE BOOK_ID = ?",p="";
		String result="FAIL";
		PreparedStatement ps = null;
		try {

			sql+=p;
			System.out.println(sql);
			ps = connection.prepareStatement(sql);
			int res=ps.executeUpdate();
			System.out.println(sql);
		    
			if(res>0)
				result="ROW DELETED SUCCESSFULLY";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	public static void main(String[] args) {
		BookDaoImpl obj=new BookDaoImpl();
		System.out.println( obj.deleteBook("null"));
	}

}
