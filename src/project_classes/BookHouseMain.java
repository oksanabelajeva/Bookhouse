package project_classes;

import java.util.Scanner;

public class BookHouseMain {
    private static DBConnection bookHouse;
    private static Owner currentUser;

    public static void main(String[] args) {
        bookHouse = new DBConnection();
        currentUser = new Owner();
        int menuEntry;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");

        do {
            System.out.println("Please select what to do:");
//            System.out.println("0 - Login");
            System.out.println("1 - Add a new book");
            System.out.println("2 - See information about all Your books");
            System.out.println("3 - Find book by: Name (type A), Author (type B), Genre (type C), Rating (type D), ID (type E)");
            System.out.println("4 - Check how many books have been read");
            System.out.println("5 - Delete book entry from Your library");
            System.out.println("99 - Exit");
            menuEntry = scanner.nextInt();
            Book newBook = new Book();

            switch (menuEntry) {
//                case 0:
//                    System.out.println("Please enter your nickname: ");
//                    String userInputNickname = scanner.nextLine();
//                    if (currentUser.getOwnerNickname().equals(userInputNickname) || currentUser.getOwnerNickname().equals(null)) {
//                        currentUser = currentUser;
//                        System.out.println("Login is successful.");
//                    } else {
//                        System.out.println("Please register.");
//                        currentUser = Owner.insertInformationOwner();
//                        System.out.println("The owner is saved.\n");
//                    }
//                    break;
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
                    System.out.println("Enter ID of book you want to delete: ");
                    bookHouse.findBookByIdAndDelete(scanner.next());
                    break;
                case 99:
                    System.out.println("The program is closed! Thank you and see you soon!");
                    break;
                default:
                    System.out.println("Menu item does not exist.");
            }
        } while (menuEntry != 99);
    }

    private static void findBookByOneOfParameters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To find book by title press A");
        System.out.println("To find book by author press B");
        System.out.println("To find book by genre press C");
        System.out.println("To find book by rating press D");
        System.out.println("To find book by ID press E");
        switch (scanner.next()) {
            case "A":
                System.out.println("Enter the title of the book you want to find: ");
                bookHouse.findBookByTitle(scanner.next());
                break;
            case "B":
                System.out.println("Enter the name of the author you want to find: ");
                bookHouse.findBookByAuthor(scanner.next());
                break;
            case "C":
                System.out.println("Enter the genre of the books you want to find: ");
                bookHouse.findBookByGenre(scanner.next());
                break;
            case "D":
                System.out.println("Enter the rating of the books you want to find: ");
                bookHouse.findBookByRating(scanner.next());
                break;
            case "E":
                System.out.println("Enter the index of the book you want to find: ");
                bookHouse.findBookById(scanner.next());
                break;
        }
    }
}