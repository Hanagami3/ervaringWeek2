package be.intecbrussel.model.book;

import be.intecbrussel.model.user.Admin;
import be.intecbrussel.model.user.User;
import be.intecbrussel.repository.BookRepository;

import java.time.LocalDate;

public abstract class Book {
    private int bookIDNO;
    private String bookTitle;
    private String bookAuthor;
    private int bookPublishYear;
    public boolean bookInLibrary;
    public boolean bookReserved;
    private User whereIsTheBook;
    private User bookReservedBy;
    private int reservedBy;
    private int borrowedBy;
    private LocalDate dueDate;
    private java.time.LocalDate issueDate;
    private BookRepository bookRepository;
    private BookStatus status;
    public Book()
    {}
    public Book(Integer bookIdNo , String bookTitle, String bookAuthor , int bookPublishYear, boolean bookInLibrary, boolean bookReserved)
    {
        this.bookIDNO = bookIdNo;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublishYear = bookPublishYear;
        this.bookInLibrary = bookInLibrary;
        this.bookReserved = bookReserved;
        this.whereIsTheBook=new Admin();
        this.bookReservedBy = null;
    }


    public Book(String bookTitle, String bookAuthor, int bookPublishYear, BookStatus status) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublishYear = bookPublishYear;
        this.status = status;
    }

    public int getBookIDNO() {
        return bookIDNO;
    }

    public void setBookIDNO(int bookIDNO) {
        this.bookIDNO = bookIDNO;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPublishYear() {
        return bookPublishYear;
    }

    public void setBookPublishYear(int bookPublishYear) {
        this.bookPublishYear = bookPublishYear;
    }


    public Boolean isBookInLibrary() {
        return bookInLibrary;
    }

    public void setBookInLibrary(Boolean bookInLibrary) {
        this.bookInLibrary = bookInLibrary;
    }

    public boolean isBookReserved() {
        return bookReserved;
    }

    public void setBookReserved(boolean bookReserved) {
        this.bookReserved = bookReserved;
    }


    public User getWhereIsTheBook() {
        return whereIsTheBook;
    }

    public void setWhereIsTheBook(User whereIsTheBook) {
        this.whereIsTheBook = whereIsTheBook;
    }

    public User getBookReservedBy() {
        return bookReservedBy;
    }

    public void setBookReservedBy(User bookReservedBy) {
        this.bookReservedBy = bookReservedBy;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public int getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(int reservedBy) {
        this.reservedBy = reservedBy;
    }

    public int getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(int borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return
                " Book Id   " + bookIDNO  +
                " Book Title  " + bookTitle  +
                " BookAuthor  " + bookAuthor  +
                " BookPublishYear  " + bookPublishYear +
                " BookInLibrary    " + bookInLibrary;
    }
}
