package be.intecbrussel.model.book;


public class FictionBooks extends Book{
    public FictionBooks(Integer bookIdNo, String bookTitle, String bookAuthor, int bookPublishYear, boolean bookInLibrary, boolean bookReserved) {
        super(bookIdNo, bookTitle, bookAuthor, bookPublishYear, bookInLibrary, bookReserved);
    }
}

