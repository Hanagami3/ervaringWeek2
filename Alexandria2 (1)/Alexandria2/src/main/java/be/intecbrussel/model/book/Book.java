package be.intecbrussel.model.book;

import be.intecbrussel.model.user.Admin;
import be.intecbrussel.model.user.User;

public abstract class Book {
private int bookIDNO;
private String bookTitle;
private String bookAuthor;
private int bookPublishYear;
public Boolean bookInLibrary;
public boolean bookReserved;
private User whereIsTheBook;
private User bookReservedBy;

public Book()
{}
public Book(Integer bookIdNo , String bookTitle, String bookAuthor , int bookPublishYear, Boolean bookInLibrary, boolean bookReserved)
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
