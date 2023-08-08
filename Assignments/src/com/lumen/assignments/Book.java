package com.lumen.assignments;



public class Book {
        String title;

        String author;

        double price;
        void getDetails(){

            System.out.println("Title of the book "+title);

            System.out.println("Author name "+author);

            System.out.println("Price of the book "+price);

        }

        void checkBookType(double price) {

            if(price > 500) {

                System.out.println("Premium Books");

            }

            else {

                System.out.println("Standard Books");

            }

        }

}

 