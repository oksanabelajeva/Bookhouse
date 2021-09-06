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
                            "is_read TEXT NOT NULL " +
// !!! AFTER THE CODE WILL BE USED, MUST PRINT COMA AFTER NULL!!!
//                            "owner_id INTEGER NOT NULL, " +
//                            "FOREIGN KEY (owner_id) REFERENCES owner(id) )";
//            String sqlStatement2 =
//                    "CREATE TABLE IF NOT EXISTS owner" +
//                            " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                            "owner_name TEXT NOT NULL, " +
//                            "owner_surname TEXT NOT NULL, " +
//                            "owner_phone TEXT NOT NULL, " +
//                            "owner_email TEXT NOT NULL " +
                            ")";
            statement.execute(sqlStatement);
//            statement.execute(sqlStatement2);
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
            System.out.println();
            System.out.println("Please see the full list of books:");
            while (rs.next()) {
                book.setId(rs.getInt("id"));
                book.setBookTitle(rs.getString("book_title"));
                book.setAuthorName(rs.getString("author_name"));
                book.setAuthorSurname(rs.getString("author_surname"));
                book.setIsbn(rs.getInt("isbn"));
                book.setNumberOfPages(rs.getInt("number_of_pages"));
                book.setReadersBookScore(rs.getInt("readers_book_score"));
                book.setYearBookWasPublished(rs.getInt("year_book_was_published"));
                book.setGenre(rs.getString("genre"));
                book.setRead(Boolean.parseBoolean(rs.getString("is_read")));
                System.out.println(book);
            }
            System.out.println("That's all.\n");
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void findBookByTitle(String bookTitle) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "SELECT book_title, author_name, author_surname " +
                    "FROM books WHERE book_title = '" + bookTitle + "';";
            ResultSet res = statement.executeQuery(sqlStatement);
            while (res.next()) {
                System.out.println("The book was found.\nTitle: " + res.getString("book_title") +
                        ", author name: " + res.getString("author_name") +
                        ", author surname: " + res.getString("author_surname") + "\n");
            }
        } catch (SQLException exception) {
            System.out.println("Sorry, no such book in BookHouse.\n");
        }
    }

    public void findBookByAuthor(String authorName) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "SELECT book_title, author_name, author_surname " +
                    "FROM books WHERE author_name = '" + authorName + "';";
            ResultSet res = statement.executeQuery(sqlStatement);
            while (res.next()) {
                System.out.println("The book was found.\nTitle: " + res.getString("book_title") +
                        ", author name: " + res.getString("author_name") +
                        ", author surname: " + res.getString("author_surname") + "\n");
            }
        } catch (SQLException exception) {
            System.out.println("Sorry, no such book in BookHouse.\n");
        }
    }

    public void findBookByGenre(String genre) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "SELECT book_title, author_name, author_surname, genre " +
                    "FROM books WHERE genre LIKE '%" + genre + "%';";
            ResultSet res = statement.executeQuery(sqlStatement);
            while (res.next()) {
                System.out.println("The book was found.\nTitle: " + res.getString("book_title") +
                        ", author name: " + res.getString("author_name") +
                        ", author surname: " + res.getString("author_surname") +
                        ", genre: " + res.getString("genre") + "\n");
            }
        } catch (SQLException exception) {
            System.out.println("Sorry, no such book in BookHouse.\n");
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
                        ", reader's book score: " + res.getInt("readers_book_score") + "\n");
            }
        } catch (SQLException exception) {
            System.out.println("Sorry, no such book in BookHouse.\n");
        }
    }

    public void removeBookByIndex(Integer id) {
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = "DELETE FROM books WHERE id = '" + id + "';";
            statement.execute(sqlStatement);
        } catch (SQLException exception) {
            System.out.println("Wrong ID! This book does not exist.");
        }
    }

    public void getBooksReadCounter(Book book) {
        try {
            int booksReadCounter = 0;
            Statement statement = connection.createStatement();
//            String sqlStatement = "SELECT COUNT (*) as booksReadCounter FROM books WHERE (is_read == true);";
//            String sqlStatement = "SELECT COUNT (*) as booksReadCounter FROM books WHERE is_read = true;";
            String sqlStatement = "SELECT COUNT([is_read]) AS booksReadCounter FROM books WHERE is_read = 'true';";
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                booksReadCounter++;
            }
            System.out.println("You have already read " + booksReadCounter + " books!");
        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }
}