package project_classes;

import project_classes.Book;

import java.sql.*;
import java.util.ArrayList;

public class DBConn {


    private Connection conn;

    public DBConn() {
        try {
            String dbUrl = "jdbc:sqlite:bookhouse.db";
            conn = DriverManager.getConnection(dbUrl);

            Statement statement = conn.createStatement();
            String sqlStatement =
                    "CREATE TABLE IF NOT EXISTS books" +
                            " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "book_title TEXT NOT NULL, " +
                            "author_name TEXT NOT NULL, " +
                            "author_surname TEXT NOT NULL, " +
                            "isbn INTEGER NOT NULL, " +
                            "number_of_pages INTEGER NOT NULL, " +
                            "readers_book_score INTEGER NOT NULL)";
            statement.execute(sqlStatement);
            System.out.println("DB created");
        } catch (SQLException exception) {
            System.out.println("Database issues: " + exception);
        }
    }

    public ArrayList<Book> getBooks() {

        ArrayList<Book> bookList = new ArrayList<Book>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM books";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while ( rs.next() ) {

                // Create new Book object
                Book boook = new Book();
                boook.setBookTitle(rs.getString("book_title"));
                boook.setAuthorName( rs.getString("author_name"));
                boook.setAuthorSurname( rs.getString("author_surname"));
                boook.setIsbn(rs.getInt("isbn"));
                boook.setNumberOfPages(rs.getInt("number_of_pages"));
                boook.setReadersBookScore(rs.getInt("readers_book_score"));
                System.out.println(boook.toString());
            }


        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }

        return bookList;
    }

    public void addBook(Book book) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO books (" +
                    "book_title, author_name, author_surname, isbn, number_of_ pages, readers_book_score) " +
                    "VALUES (" +
                    "'" + book.getBookTitle() + "'," +
                    "'" + book.getAuthorName() + "'," +
                    "'" + book.getAuthorSurname() + "'," +
                    "'" + book.getIsbn() + "'," +
                    "'" + book.getNumberOfPages() + "'," +
                    book.getReadersBookScore() +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }
}

