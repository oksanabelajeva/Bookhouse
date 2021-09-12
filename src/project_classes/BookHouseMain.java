package project_classes;

import java.util.Scanner;

public class BookHouseMain {
    private static DBConnection bookHouse;

    public static void main(String[] args) {
        bookHouse = new DBConnection();
        int menuEntry;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome in the Book House!");

        do {
            System.out.println("\nPlease select what to do:\n" +
                    "1 - Add a new book\n2 - See information about all Your books\n" +
                    "3 - Find book by Name, Author, Genre, Rating, ID\n" +
                    "4 - Check how many books have been read\n5 - Update book's information\n" +
                    "6 - Delete book entry from Your library\n99 - Exit");
            menuEntry = scanner.nextInt();
            Book newBook = new Book();

            switch (menuEntry) {
                case 1:
                    newBook = BookMethods.insertInformationAboutBook();
                    bookHouse.addBook(newBook);
                    System.out.println("The book is saved.\n");
                    break;
                case 2:
                    bookHouse.getBooks(newBook);
                    break;
                case 3:
                    findBookByOneOfParameters();
                    break;
                case 4:
                    bookHouse.getBooksReadCounter(newBook);
                    break;
                case 5:
                    bookHouse.getBooks(newBook);
                    System.out.println("\nPlease enter book's ID:");
                    int bookId = scanner.nextInt();
                    bookHouse.updateBook(bookId);
                    break;
                case 6:
                    System.out.println("Enter ID of book you want to delete:");
                    bookHouse.findBookByIdAndDelete(scanner.next());
                    break;
                case 99:
                    System.out.println("The program is closed! Thank you and see you soon!");
                    break;
                default:
                    System.out.println("Menu item does not exist.\n");
            }
        } while (menuEntry != 99);
    }

    private static void findBookByOneOfParameters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To find book:\n- by title press 1\n- by author press 2" +
                "\n- by genre press 3\n- by rating press 4\n- by ID press 5");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Enter the title of the book you want to find: ");
                bookHouse.findBookByTitle(scanner.next());
                break;
            case 2:
                System.out.println("Enter the name of the author you want to find: ");
                bookHouse.findBookByAuthor(scanner.next());
                break;
            case 3:
                System.out.println("Enter the genre of the books you want to find: ");
                bookHouse.findBookByGenre(scanner.next());
                break;
            case 4:
                System.out.println("Enter the rating of the books you want to find: ");
                bookHouse.findBookByRating(scanner.next());
                break;
            case 5:
                System.out.println("Enter the index of the book you want to find: ");
                bookHouse.findBookById(scanner.next());
                break;
            default:
                System.out.println("Menu item does not exist.");
        }
    }
}