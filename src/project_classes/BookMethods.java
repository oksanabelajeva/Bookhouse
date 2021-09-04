package project_classes;

import java.util.Scanner;

public class BookMethods {
    final static Scanner scanner = new Scanner(System.in);
    final static Book newBook = new Book();

    public static Book insertInformationAboutBook() {
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
        System.out.println("Enter rating (from 1 to 5; zero if not read): ");
        newBook.setReadersBookScore(scanner.nextInt());
        System.out.println("Enter year the book was published: ");
        newBook.setYearBookWasPublished(scanner.nextInt());
        System.out.println("Enter genre: ");
        newBook.setGenre(scanner.next());
        System.out.println("Did you read the book (true/ false): ");
        newBook.setRead(booleanScanner());
        return newBook;
    }

    private static boolean booleanScanner() {
        scanner.next();
        if (scanner.equals("yes")) {
            System.out.println("YES");
            return true;
        } else if (scanner.equals("no")) {
            System.out.println("NO");
            return false;
        } else {
            return false;
        }
    }

    public static void insertIndexOfBookToBeDeleted() {
        System.out.println("Enter ID of book you want to delete: ");
        newBook.setIsbn(scanner.nextInt());
    }
}