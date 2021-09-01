package project_classes;

import java.util.ArrayList;
import java.util.Scanner;

public class BookHouseMain {

            private static DBConn bookhouse;
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                bookhouse = new DBConn();

                bookhouse.getBooks();

                ArrayList<Book> bookList = new ArrayList<Book>();
                private static void addNewBook(Scanner scanner,String[] bookList) {
                    Book newBoook = new Book();
                    System.out.println("Enter book name:  ");
                    newBoook.setBookTitle(scanner.next());
                    System.out.println("Enter author name: ");
                    newBoook.setAuthorName(scanner.next());
                    System.out.println("Enter author surname:  ");
                    newBoook.setAuthorSurname(scanner.next());
                    System.out.println("Enter ISBN: ");
                    newBoook.setIsbn(scanner.nextInt());
                    System.out.println("Enter number of pages:  ");
                    newBoook.setNumberOfPages(scanner.nextInt());
                    System.out.println("Enter rating:  ");
                    newBoook.setReadersBookScore(scanner.nextInt());
                    // Add new book to database
                    bookhouse.addBook(newBoook);
                }
                addNewBook(scanner, bookList);
            }
    }

