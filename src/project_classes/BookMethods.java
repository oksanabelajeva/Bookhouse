package project_classes;

import java.util.Scanner;

public class BookMethods {
    final static Scanner scanner = new Scanner(System.in);
    final static Book newBook = new Book();

    public static Book insertInformationAboutBook() {
        System.out.println("Enter book name: ");
        newBook.setBookTitle(scanner.nextLine());
        System.out.println("Enter author name: ");
        newBook.setAuthorName(scanner.nextLine());
        System.out.println("Enter author surname:  ");
        newBook.setAuthorSurname(scanner.nextLine());
        System.out.println("Enter ISBN: ");
        enterIsbnValue();
        System.out.println("Enter number of pages: ");
        enterNumberOfPages();
        System.out.println("Enter rating (from 1 to 5; zero if not read): ");
//        checkEnteredReadersBookScore();
        enterReadersBookScore();
        System.out.println("Enter year the book was published: ");
        enterYearBookWasPublished();
        System.out.println("Enter genre: ");
        newBook.setGenre(scanner.nextLine());
        System.out.println("Did you read the book (yes/ no): ");
        booleanScanner();
        return newBook;
    }

    private static void enterIsbnValue() {
        if (scanner.hasNextInt()) {
            newBook.setIsbn(scanner.nextInt());
        } else {
            System.out.println("You entered incorrect value. It will be saved zero.\nAfter information is saved, choose to change information about book.");
            scanner.nextLine();
        }
    }

    private static void enterNumberOfPages() {
        if (scanner.hasNextInt()) {
            newBook.setNumberOfPages(scanner.nextInt());
        } else {
            System.out.println("You entered incorrect value. It will be saved zero.\nAfter information is saved, choose to change information about book.");
            scanner.nextLine();
        }
    }

    private static void enterReadersBookScore() {
        if (scanner.hasNextInt()) {
            newBook.setReadersBookScore(scanner.nextInt());
        } else {
            System.out.println("You entered incorrect value. It will be saved zero.\nAfter information is saved, choose to change information about book.");
            scanner.nextLine();
        }
    }

//    private static void checkEnteredReadersBookScore() {
//        if (scanner.hasNextInt()) {
//            int enteredReadersScore = scanner.nextInt();
//            while (enteredReadersScore < 0 || enteredReadersScore > 5) {
//                System.out.println("Please, enter score from 0 to 5.");
//                enteredReadersScore = scanner.nextInt();
//                break;
//            }
//            newBook.setReadersBookScore(scanner.nextInt());
//        } else {
//            System.out.println("You entered incorrect value. It will be saved zero.\nAfter information is saved, choose to change information about book.");
//            scanner.nextLine();
//        }
//    }

    private static void enterYearBookWasPublished() {
        if (scanner.hasNextInt()) {
            newBook.setYearBookWasPublished(scanner.nextInt());
        } else {
            System.out.println("You entered incorrect value. It will be saved zero.\nAfter information is saved, choose to change information about book.");
            scanner.nextLine();
        }
    }

    private static boolean booleanScanner() {
        if (scanner.nextLine().equals("yes")) {
            newBook.setRead(true);
        } else {
            newBook.setRead(false);
        }
        return true;
    }
}