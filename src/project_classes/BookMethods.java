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
        newBook.setIsbn(scanner.nextLine());
        System.out.println("Enter number of pages: ");
        enterNumberOfPages();
        System.out.println("Enter rating (from 1 to 5; zero if not read): ");
        boolean validator = false;
        while (!validator) {
            validator = checkEnteredReadersBookScore();
        }
        System.out.println("Enter year the book was published: ");
        boolean validatorSecond = false;
        while (!validatorSecond) {
            validatorSecond = enterYearBookWasPublished();
        }
        System.out.println("Enter genre: ");
        newBook.setGenre(scanner.nextLine());
        System.out.println("Did you read the book (yes/ no): ");
        booleanScanner();
        return newBook;
    }

    private static void enterNumberOfPages() {
        if (scanner.hasNextInt()) {
            newBook.setNumberOfPages(scanner.nextInt());
            scanner.nextLine();
        } else {
            System.out.println("You entered incorrect value. Please try again.");
            scanner.nextLine();
        }
    }

    private static boolean checkEnteredReadersBookScore() {
        if (scanner.hasNextInt()) {
            int enteredReadersScore = scanner.nextInt();
            scanner.nextLine();
            if (enteredReadersScore < 0 || enteredReadersScore > 5) {
                System.out.println("Please enter score from 1 to 5; zero if book is not read.");
                return false;
            } else {
                newBook.setReadersBookScore(enteredReadersScore);
                return true;
            }
        } else {
            System.out.println("You entered incorrect value.\nPlease enter score from 1 to 5; zero if book is not read.");
            scanner.nextLine();
            return false;
        }
    }

    private static boolean enterYearBookWasPublished() {
        if (scanner.hasNextInt()) {
            newBook.setYearBookWasPublished(scanner.nextInt());
            scanner.nextLine();
            return true;
        } else {
            System.out.println("You entered incorrect value. Please try again.");
            scanner.nextLine();
            return false;
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