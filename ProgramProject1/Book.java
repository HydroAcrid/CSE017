//package ProgramProject1;

public class Book extends Titles {
    
    private long isbn;
    private String author;

    public Book() {
        super();
        isbn = 0;
    }

    public Book(String callNum, String title, String publisher, int pubDate, int copies, String author, long isbn) {
        super(callNum, title, publisher, pubDate, copies);
        this.author = author;
        this.isbn = isbn;

    }

    public long getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // public int compareTo(Book literature) {
    //     return this.getPubDate() - literature.getPubDate();
    // }

    public void isRestorable() {

    }

    public String toString() {
        return String.format("%s          %-20s     %s ", super.toString(), author, isbn);
    }

    public String simpleString() {
        return String.format("%s\n%s\n%s", super.simpleString(), author, isbn);
    }
}
