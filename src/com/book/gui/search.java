package com.book.gui;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.book.dao.impl.BookDaoImpl;
import com.book.entity.Book;

public class search extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBookId;
	private JTextField txtBookName;
	private JTextField txtBookPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search frame = new search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public search() {
		setTitle("SEARCH BOOK");
		setFont(new Font("Bell MT", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookId = new JLabel("BOOK ID");
		lblBookId.setBounds(26, 48, 99, 14);
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblBookId);
		
		JLabel lblBookName = new JLabel("BOOK NAME");
		lblBookName.setBounds(26, 93, 99, 14);
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblBookName);
		
		JLabel lblBookPrice = new JLabel("BOOK PRICE");
		lblBookPrice.setBounds(26, 147, 99, 14);
		lblBookPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblBookPrice);
		
		txtBookId = new JTextField();
		txtBookId.setBounds(134, 45, 156, 20);
		txtBookId.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(txtBookId);
		txtBookId.setColumns(10);
		
		txtBookName = new JTextField();
		txtBookName.setBounds(135, 91, 155, 20);
		txtBookName.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(txtBookName);
		txtBookName.setColumns(10);
		
		txtBookPrice = new JTextField();
		txtBookPrice.setBounds(134, 145, 156, 20);
		txtBookPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(txtBookPrice);
		txtBookPrice.setColumns(10);
	    txtBookPrice.setText("0");
		
		JButton btnSave = new JButton("SEARCH");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Book book=new Book(txtBookId.getText(),txtBookName.getText(),Double.parseDouble(txtBookPrice.getText()));
				BookDaoImpl dao=new BookDaoImpl();
				ArrayList<Book> list=dao.searchBook(book);
				
				String str="ID    NAME   PRICE";
				
				if(list.isEmpty())
					str="NO RECORD MATCH WITH GIVEN DETAILS";
				
				for (Book obj : list) {
					str=str+"  \n"+obj.getBookId()+"   "+obj.getBookName()+"   "+Double.toString(obj.getBookPrice());
					
				}
				
			
				
				JOptionPane.showMessageDialog(contentPane,str);
			    
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBounds(141, 198, 89, 23);
		contentPane.add(btnSave);
	}

}
