package com.lumen.assignments;
public class BookMain {
    public static void main(String[] args) {
        Book book = new Book();

        book.title = "All passion spent";

        book.author = "Vita Sackville";

        book.price = 390;

        book.getDetails();
        Book book1 = new Book();

        book1.title = "Absolom";

        book1.author = "William";

        book1.price = 459;

        book1.getDetails();

        book1.checkBookType(book1.price);

    }

 

}