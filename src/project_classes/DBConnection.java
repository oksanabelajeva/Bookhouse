package project_classes;

import java.sql.*;
import java.util.Scanner;

public class DBConnection {

    private Connection connection;

    public DBConnection() {
        try {
            String dbUrl = "jdbc:sqlite:bookhouse.db";
            connection = DriverManager.getConnection(dbUrl);
            Statement statement = connection.createStatement();
            String sqlStatement =
                    "CREATE TABLE IF NOT EXISTS books" +
                            " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "book_title TEXT NOT NULL, " +
                            "author_name TEXT NOT NULL, " +
                            "author_surname TEXT NOT NULL, " +
                            "isbn INTEGER NOT NULL, " +
                            "number_of_pages INTEGER NOT NULL, " +
                            "readers_book_score INTEGER NOT NULL, " +
                            "year_book_was_published INTEGER NOT NULL," +
                            "genre TEXT NOT NULL," +
                            "is_read TEXT NOT NULL " +
                            ")";
            statement.execute(sqlStatement);
            System.out.println("DB created");
        } catch (SQLException exception) {
            System.out.println("Database issues: " + exception);
        }
    }

    public void addBook(Book book) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "INSERT INTO books (" +
                    "book_title, author_name, author_surname, isbn, number_of_pages, readers_book_score, " +
                    "year_book_was_published, genre, is_read)" +
                    "VALUES ('" +
                    book.getBookTitle() + "', " +
                    "'" + book.getAuthorName() + "', " +
                    "'" + book.getAuthorSurname() + "', " +
                    "'" + book.getIsbn() + "', " +
                    "'" + book.getNumberOfPages() + "', " +
                    "'" + book.getReadersBookScore() + "', " +
                    "'" + book.getYearBookWasPublished() + "', " +
                    "'" + book.getGenre() + "', " +
                    "'" + book.isRead() + "'" +
                    ")";
            statement.execute(sqlStatement);
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void getBooks(Book book) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "SELECT * FROM books";
            ResultSet rs = statement.executeQuery(sqlStatement);
            System.out.println("Please see the full list of books:");
//            if (rs.next() == false){
//                System.out.println("There is no books in the database.\n");
//            }
            while (rs.next()) {
                book.setId(rs.getInt("id"));
                book.setBookTitle(rs.getString("book_title"));
                book.setAuthorName(rs.getString("author_name"));
                book.setAuthorSurname(rs.getString("author_surname"));
                book.setIsbn(rs.getString("isbn"));
                book.setNumberOfPages(rs.getInt("number_of_pages"));
                book.setReadersBookScore(rs.getInt("readers_book_score"));
                book.setYearBookWasPublished(rs.getInt("year_book_was_published"));
                book.setGenre(rs.getString("genre"));
                book.setRead(Boolean.parseBoolean(rs.getString("is_read")));
                System.out.println(book);
            }
            System.out.println("That's all.");
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void findBookByTitle(String bookTitle) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "SELECT book_title, author_name, author_surname " +
                    "FROM books WHERE book_title LIKE '%" + bookTitle + "%';";
            ResultSet res = statement.executeQuery(sqlStatement);
            if (res.next()) {
                System.out.println("The book was found.\nTitle: " + res.getString("book_title") +
                        ", author name: " + res.getString("author_name") +
                        ", author surname: " + res.getString("author_surname"));
            } else {
                System.out.println("Sorry, no such book in BookHouse.");
            }
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void findBookByAuthor(String authorName) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "SELECT book_title, author_name, author_surname " +
                    "FROM books WHERE author_name LIKE '%" + authorName + "%';";
            ResultSet res = statement.executeQuery(sqlStatement);
            if (res.next()) {
                System.out.println("The book was found.\nTitle: " + res.getString("book_title") +
                        ", author name: " + res.getString("author_name") +
                        ", author surname: " + res.getString("author_surname"));
            } else {
                System.out.println("Sorry, no such book in BookHouse.");
            }
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void findBookByGenre(String genre) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "SELECT book_title, author_name, author_surname, genre " +
                    "FROM books WHERE genre LIKE '%" + genre + "%';";
            ResultSet res = statement.executeQuery(sqlStatement);
            if (res.next()) {
                System.out.println("The book was found.\nTitle: " + res.getString("book_title") +
                        ", author name: " + res.getString("author_name") +
                        ", author surname: " + res.getString("author_surname") +
                        ", genre: " + res.getString("genre"));
            } else {
                System.out.println("Sorry, no such book in BookHouse.");
            }
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void findBookByRating(String readersBookScore) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "SELECT book_title, author_name, author_surname, genre, readers_book_score " +
                    "FROM books WHERE readers_book_score = '" + readersBookScore + "';";
            ResultSet res = statement.executeQuery(sqlStatement);
            while (res.next()) {
                System.out.println("The book was found.\nTitle: " + res.getString("book_title") +
                        ", author name: " + res.getString("author_name") +
                        ", author surname: " + res.getString("author_surname") +
                        ", genre: " + res.getString("genre") +
                        ", reader's book score: " + res.getInt("readers_book_score"));
            }
//            else {
//                System.out.println("Sorry, no such book in BookHouse.");
//            }
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void findBookById(String id) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "SELECT book_title, author_name, author_surname, genre, readers_book_score " +
                    "FROM books WHERE id = '" + id + "';";
            ResultSet res = statement.executeQuery(sqlStatement);
            if (res.next()) {
                System.out.println("The book with id " + id + " was found.\nTitle: " + res.getString("book_title") +
                        ", author name: " + res.getString("author_name") +
                        ", author surname: " + res.getString("author_surname") +
                        ", genre: " + res.getString("genre") +
                        ", reader's book score: " + res.getInt("readers_book_score"));
            } else {
                System.out.println("Sorry, no book with id " + id + " is in BookHouse.");
            }
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void getBooksReadCounter(Book book) {
        try {
            int numberOfReadBook = 0;
            Statement statement = connection.createStatement();
            String sqlStatement = "SELECT COUNT(*) AS booksReadCounter FROM books WHERE is_read = 'true';";
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                numberOfReadBook = rs.getInt("booksReadCounter");
            }
            System.out.println("You have already read " + numberOfReadBook + " books!");
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void updateBook(int id) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "SELECT * FROM books WHERE id = '" + id + "';";
            ResultSet res = statement.executeQuery(sqlStatement);
            while (res.next()) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nWhat would you like to change?\n- Title press 1\n- Author's name press 2" +
                        "\n- Author's surname press 3\n- ISBN press 4\n- Number of pages press 5" +
                        "\n- Reader's book score press 6\n- Year book was published press 7" +
                        "\n- Genre press 8\n- Is book read press 9");
                int menuItem = scanner.nextInt();
                scanner.nextLine();
                switch (menuItem) {
                    case 1:
                        System.out.println("Enter new title:");
                        PreparedStatement preparedStatementTitle = connection.prepareStatement
                                ("UPDATE books SET book_title = ? WHERE id = ?");
                        preparedStatementTitle.setString(1, scanner.nextLine());
                        preparedStatementTitle.setInt(2, id);
                        preparedStatementTitle.executeUpdate();
                        break;
                    case 2:
                        System.out.println("Enter new name of the author:");
                        PreparedStatement preparedStatementName = connection.prepareStatement
                                ("UPDATE books SET author_name = ? WHERE id = ?");
                        preparedStatementName.setString(1, scanner.nextLine());
                        preparedStatementName.setInt(2, id);
                        preparedStatementName.executeUpdate();
                        break;
                    case 3:
                        System.out.println("Enter new surname of the author:");
                        PreparedStatement preparedStatementSurname = connection.prepareStatement
                                ("UPDATE books SET author_surname = ? WHERE id = ?");
                        preparedStatementSurname.setString(1, scanner.nextLine());
                        preparedStatementSurname.setInt(2, id);
                        preparedStatementSurname.executeUpdate();
                        break;
                    case 4:
                        System.out.println("Enter new ISBN: ");
                        PreparedStatement preparedStatementIsbn = connection.prepareStatement
                                ("UPDATE books SET isbn = ? WHERE id = ?");
                        preparedStatementIsbn.setString(1, scanner.nextLine());
                        preparedStatementIsbn.setInt(2, id);
                        preparedStatementIsbn.executeUpdate();
                        break;
                    case 5:
                        System.out.println("Enter new number of pages: ");
                        PreparedStatement preparedStatementNumberOfPages = connection.prepareStatement
                                ("UPDATE books SET number_of_pages = ? WHERE id = ?");
                        preparedStatementNumberOfPages.setInt(1, scanner.nextInt());
                        preparedStatementNumberOfPages.setInt(2, id);
                        preparedStatementNumberOfPages.executeUpdate();
                        break;
                    case 6:
                        System.out.println("Enter new reader's book score: ");
                        PreparedStatement preparedStatementReadersBookScore = connection.prepareStatement
                                ("UPDATE books SET readers_book_score = ? WHERE id = ?");
                        preparedStatementReadersBookScore.setInt(1, scanner.nextInt());
                        preparedStatementReadersBookScore.setInt(2, id);
                        preparedStatementReadersBookScore.executeUpdate();
                        break;
                    case 7:
                        System.out.println("Enter new year book was published:");
                        PreparedStatement preparedStatementYearBookWasPublished = connection.prepareStatement
                                ("UPDATE books SET year_book_was_published = ? WHERE id = ?");
                        preparedStatementYearBookWasPublished.setInt(1, scanner.nextInt());
                        preparedStatementYearBookWasPublished.setInt(2, id);
                        preparedStatementYearBookWasPublished.executeUpdate();
                        break;
                    case 8:
                        System.out.println("Enter new Genre:");
                        PreparedStatement preparedStatementGenre = connection.prepareStatement
                                ("UPDATE books SET genre = ? WHERE id = ?");
                        preparedStatementGenre.setString(1, scanner.nextLine());
                        preparedStatementGenre.setInt(2, id);
                        preparedStatementGenre.executeUpdate();
                        break;
                    case 9:
                        System.out.println("Change item 'Is read':");
                        PreparedStatement preparedStatementIsRead = connection.prepareStatement
                                ("UPDATE books SET is_read = ? WHERE id = ?");
                        preparedStatementIsRead.setString(1, scanner.nextLine());
                        preparedStatementIsRead.setInt(2, id);
                        preparedStatementIsRead.executeUpdate();
                        break;
                    default:
                        System.out.println("Menu item does not exist.");
                }
            }
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void findBookByIdAndDelete(String id) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "SELECT book_title, author_name, author_surname, genre, readers_book_score " +
                    "FROM books WHERE id = '" + id + "';";
            ResultSet res = statement.executeQuery(sqlStatement);
            if (res.next()) {
                System.out.println("The book with id " + id + " was found.\nTitle: " + res.getString("book_title") +
                        ", author name: " + res.getString("author_name") +
                        ", author surname: " + res.getString("author_surname") +
                        ", genre: " + res.getString("genre") +
                        ", reader's book score: " + res.getInt("readers_book_score"));
                this.removeBookById(id);
            } else {
                System.out.println("Sorry, no book with id " + id + " is in BookHouse.");
            }
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void removeBookById(String id) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "DELETE FROM books WHERE id = '" + id + "';";
            statement.execute(sqlStatement);
            System.out.println("The book with " + id + " was deleted.");
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }
}