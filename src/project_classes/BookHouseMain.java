package project_classes;

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
            Book newBook = new Book();

            switch (menuEntry) {
                case 1:
                    newBook = BookMethods.insertInformationAboutBook();
                    bookHouse.addBook(newBook);
                    break;
                case 2:
                    bookHouse.getBooks(newBook);
                    break;
                case 3:
                    //Find book by:
                    break;
                case 4:
                    //Check amount of read books

                    break;
                case 5:
                    System.out.println("Enter ID of book you want to delete: ");
                    bookHouse.removeBookByIndex(scanner.nextInt());
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