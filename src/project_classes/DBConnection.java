package project_classes;

import java.sql.*;
import java.util.ArrayList;

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
                            "genre TEXT NOT NULL" +
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
                    "year_book_was_published, genre)" +
                    "VALUES ('" +
                    book.getBookTitle() + "', " +
                    "'" + book.getAuthorName() + "', " +
                    "'" + book.getAuthorSurname() + "', " +
                    "'" + book.getIsbn() + "', " +
                    "'" + book.getNumberOfPages() + "', " +
                    "'" + book.getReadersBookScore() + "', " +
                    "'" + book.getYearBookWasPublished() + "', " +
                    "'" + book.getGenre() + "'" +
                    ")";
            statement.execute(sqlStatement);
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

//    public ArrayList<Book> getBooks() {
//        ArrayList<Book> bookList = new ArrayList<>();
//        try {
//            Statement statement = connection.createStatement();
//            String sqlStatement = "SELECT * FROM books";
//            ResultSet rs = statement.executeQuery(sqlStatement);
//
//            while (rs.next()) {
//                // Create new Book object
//                Book book = new Book();
//                book.setBookTitle(rs.getString("book_title"));
//                book.setAuthorName(rs.getString("author_name"));
//                book.setAuthorSurname(rs.getString("author_surname"));
//                book.setIsbn(rs.getInt("isbn"));
//                book.setNumberOfPages(rs.getInt("number_of_pages"));
//                book.setReadersBookScore(rs.getInt("readers_book_score"));
//                System.out.println(book.toString());
//            }
//        } catch (SQLException exception) {
//            System.out.println("Error getting list of books: " + exception);
//        }
//        return bookList;
//    }
}