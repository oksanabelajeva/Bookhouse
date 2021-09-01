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


        // Method for Menu item No.5 - Delete book
//        static private void removeBook(Scanner scanner, String[] bookList) {
//            System.out.println("Please enter book index to be removed");
//        }


        // MENU
        int menuEntry;
        Scanner scanner = new Scanner(System.in);

        // 1. Add a new book
        // 2. Print information about all books;
        // 3. Find book by:
        // A - Name ; B - Author ; C- genre
        // 4. Check how many books have been read
        // 5. Delete book from library
        // 0. Exit

        do {
            // EXIT == 0
            System.out.println("Welcome!");
            System.out.println("Please select what to do:");
            System.out.println("1 - Add a new book");
            System.out.println("2 - See information about Your books");
            System.out.println("3 - Find book by: A - Name, B - Author, C - genre, D - Rating ");
            System.out.println("4 - Check how many books have been read");
            System.out.println("5 - Delete book entry from Your library");
            System.out.println("0 - Exit");
            menuEntry = scanner.nextInt();

            switch (menuEntry) {
                case 1:
                    //
                    break;
                case 2:
                    // See info about books
                   // addNewHero(scanner, heroList);
                    break;
                case 3:
                    //Find book by:
                    break;
                case 4:
                    //Check amount of read books
                    break;
                case 5:
                    //Delete book from database
                    break;
                default:
                    System.out.println("menu item does not exist");
            }

        } while (menuEntry != 0);



    }

