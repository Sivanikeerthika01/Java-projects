package com.bookapp.client;

import java.util.ArrayList;
import java.util.List;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.BookServiceImpl;



public class BookMain {

	public static void main(String[] args) {
		IBookService bookservice=new BookServiceImpl();
		List<Book> books=new ArrayList<>();
		books=bookservice.getAll();
		System.out.println(books);
		
		books=bookservice.getByAuthorContains("Ben john");
		System.out.println(books);
		
		books=bookservice.getByCategory("Tech");
		System.out.println(books);
		
		
	}

}