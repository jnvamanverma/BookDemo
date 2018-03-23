package com.book.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.book.dao.impl.BookDaoImpl;


import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class displayFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayFrame frame = new displayFrame();
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
	public displayFrame() {
		setTitle("BOOK DISPLAY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTextArea textAreaDisplay = new JTextArea();
		textAreaDisplay.setBounds(10, 64, 414, 186);
		contentPane.add(textAreaDisplay);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookDaoImpl obj=new BookDaoImpl();
				ArrayList<com.book.entity.Book> list=obj.getAll();
				
				String str="ID    NAME   PRICE";
				
				for (com.book.entity.Book book : list) {
					str=str+"  \n"+book.getBookId()+"   "+book.getBookName()+"   "+Double.toString(book.getBookPrice());
				}
				
				textAreaDisplay.setText(str);
				
			}
		});
		btnDisplay.setBounds(163, 26, 89, 23);
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnDisplay);
		
		
	}
}
