package project_classes;

import java.sql.*;

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
                            "is_read TEXT NOT NULL" +
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
        // must be text "There is no books" if the database is empty
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "SELECT * FROM books";
            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                book.setBookTitle(rs.getString("book_title"));
                book.setAuthorName(rs.getString("author_name"));
                book.setAuthorSurname(rs.getString("author_surname"));
                book.setIsbn(rs.getInt("isbn"));
                book.setNumberOfPages(rs.getInt("number_of_pages"));
                book.setReadersBookScore(rs.getInt("readers_book_score"));
                book.setYearBookWasPublished(rs.getInt("year_book_was_published"));
                book.setGenre(rs.getString("genre"));
                book.setRead(rs.getBoolean("is_read"));
                System.out.println(book);
            }
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

      public void removeBookByIndex(Integer id) {
        // If index 1 is deleted, there is no more index 1 database
        // How to print out information with indexes?
          try {
            Statement statement = connection.createStatement();
            String sqlStatement = "DELETE FROM books WHERE id = '" + id + "';";
            statement.execute(sqlStatement);
        } catch (SQLException exception) {
            System.out.println("Wrong ID! This book does not exist.");
        }
    }

//    public void getBooksReadCounter(Book book) {
//        try {
//            Statement statement = connection.createStatement();
//            String sqlStatement = "SELECT COUNT (*) as booksReadCounter FROM books WHERE (isRead == true)";
//            ResultSet rs = statement.executeQuery(sqlStatement);
//            int booksReadCounter = 0;
//            while (rs.next()) {
//                System.out.println("You have already read " + booksReadCounter + " books!");
//            }
//        } catch (SQLException exception) {
//            System.out.println("Error getting list of books: " + exception);
//        }
//    }

}