package project_classes;

public class Book {

    private String bookTitle;
    private String authorName;
    private String authorSurname;
    private int isbn;
    private int numberOfPages;
    private int readersBookScore;
    private int yearBookWasPublished;
    private String genre;
    private boolean isRead;

    public Book() {
    }

    public Book(String bookTitle, String authorName, String authorSurname, int isbn, int numberOfPages, int readersBookScore, int yearBookWasPublished, String genre, boolean isRead) {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.readersBookScore = readersBookScore;
        this.yearBookWasPublished = yearBookWasPublished;
        this.genre = genre;
        this.isRead = isRead;
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

    public int getYearBookWasPublished() {
        return yearBookWasPublished;
    }

    public void setYearBookWasPublished(int yearBookWasPublished) {
        this.yearBookWasPublished = yearBookWasPublished;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        String isReadToString = Boolean.toString(isRead);
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                ", isbn=" + isbn +
                ", numberOfPages=" + numberOfPages +
                ", readersBookScore=" + readersBookScore +
                ", yearBookWasPublished=" + yearBookWasPublished +
                ", genre='" + genre + '\'' +
                ", isRead=" + isReadToString +
                '}';
    }
}