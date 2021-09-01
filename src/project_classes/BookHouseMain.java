package project_classes;

import java.util.ArrayList;
import java.util.Scanner;

public class BookHouseMain {
    private static DBConnection bookHouse;

    public static void main(String[] args) {
        bookHouse = new DBConnection();
        int menuEntry;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Welcome!");
            System.out.println("Please select what to do:");
            System.out.println("1 - Add a new book");
            System.out.println("2 - See information about all Your books");
            System.out.println("3 - Find book by: Name (type A), Author (type B), genre (type C), Rating (type D)");
            System.out.println("4 - Check how many books have been read");
            System.out.println("5 - Delete book entry from Your library");
            System.out.println("0 - Exit");
            menuEntry = scanner.nextInt();

            switch (menuEntry) {
                case 1:
                    Book newBook = new Book();
                    System.out.println("Enter book name: ");
                    newBook.setBookTitle(scanner.next());
                    System.out.println("Enter author name: ");
                    newBook.setAuthorName(scanner.next());
                    System.out.println("Enter author surname:  ");
                    newBook.setAuthorSurname(scanner.next());
                    System.out.println("Enter ISBN: ");
                    newBook.setIsbn(scanner.nextInt());
                    System.out.println("Enter number of pages: ");
                    newBook.setNumberOfPages(scanner.nextInt());
                    System.out.println("Enter rating: ");
                    newBook.setReadersBookScore(scanner.nextInt());
                    System.out.println("Enter year the book was published: ");
                    newBook.setYearBookWasPublished(scanner.nextInt());
                    System.out.println("Enter genre: ");
                    newBook.setGenre(scanner.next());
                    bookHouse.addBook(newBook);
                    break;
                case 2:
                    // See info about books
                    // addNewHero(scanner, heroList);
                    // bookHouse.getBooks();
                    break;
                case 3:
                    //Find book by:
                    break;
                case 4:
                    //Check amount of read books
                    break;
                case 5:
                    //Delete book from database
                    // Method for Menu item No.5 - Delete book
//        static private void removeBook(Scanner scanner, String[] bookList) {
//            System.out.println("Please enter book index to be removed");
//        }
                    break;
                case 0:
                    System.out.println("The program is closed! Thank you and see you soon!");
                    break;
                default:
                    System.out.println("Menu item does not exist.");
            }
        } while (menuEntry != 0);
    }
}