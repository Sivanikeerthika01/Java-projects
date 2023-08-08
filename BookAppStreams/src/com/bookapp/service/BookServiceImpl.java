package com.bookapp.service;

import java.util.List;
import com.bookapp.util.Bookdetails;
import java.util.stream.Collectors;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
public class BookServiceImpl implements IBookService{
 @Override
       public List<Book> getAll() {
         List<Book> books=Bookdetails.showBooks();
         return books;
         }
 @Override
        public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
           List<Book> books=getAll();
           List<Book> getbyauthorcontains=books.stream()
		 .filter(book1->book1.getAuthor().equals(author))
          .collect(Collectors.toList());
         return getbyauthorcontains;
}

    @Override

    public List<Book> getByCategory(String category) throws BookNotFoundException {
    	List<Book> books=getAll();
    	List<Book> getbycategory=books.stream()
        		.filter(book1->book1.getCategory().equals(category))
        		.collect(Collectors.toList());
    	return (List<Book>) getbycategory;
 }

@Override

    public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {

        List<Book> books=getAll();

        List<Book> getbypricelessthan=books.stream()

                .filter(book1->book1.getPrice()>=price)

                .collect(Collectors.toList());

        return getbypricelessthan;

    }
    @Override

    public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {

        List<Book> books=getAll();

        List<Book> getbyauthorcontainsandcategory=books.stream()

                .filter(book1->book1.getAuthor().equals(author))

                .filter(book1->book1.getCategory().equals(category))

                .collect(Collectors.toList());

        return getbyauthorcontainsandcategory;

    }
@Override

    public List<Book> getById(int bookId) throws BookNotFoundException {

        List<Book> books=getAll();

        List<Book> getbyId=books.stream()

                .filter(book->book.getBookId().equals(bookId))

                .collect(Collectors.toList());

        return getbyId;

    }

 
}
