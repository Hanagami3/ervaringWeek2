package be.intecbrussel.model.book;

public class NonFictionBooks extends Book{
    public NonFictionBooks(Integer bookIdNo, String bookTitle, String bookAuthor, int bookPublishYear, boolean bookInLibrary, boolean bookReserved) {
        super(bookIdNo, bookTitle, bookAuthor, bookPublishYear, bookInLibrary, bookReserved);
    }
}
