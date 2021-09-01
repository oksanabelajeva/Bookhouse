package project_classes;

public class Book {

    public String bookTitle;
    public String authorName;
    public String authorSurname;
    public int isbn;
    public int numberOfPages;
    public int readersBookScore;

    //Non argument constructor

    public Book() {
    }

    // Argument constructor


    public Book(String bookTitle, String authorName, String authorSurname, int isbn, int numberOfPages, int readersBookScore) {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.readersBookScore = readersBookScore;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getReadersBookScore() {
        return readersBookScore;
    }

    public void setReadersBookScore(int readersBookScore) {
        this.readersBookScore = readersBookScore;
    }

}
