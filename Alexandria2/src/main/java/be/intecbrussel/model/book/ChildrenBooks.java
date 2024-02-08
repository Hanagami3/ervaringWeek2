package be.intecbrussel.model.book;


public class ChildrenBooks extends Book{
    public ChildrenBooks(Integer bookIdNo , String bookTitle, String bookAuthor , int bookPublishYear, boolean bookInLibrary, boolean bookReserved)
    {
        super(bookIdNo,bookTitle,bookAuthor,bookPublishYear,bookInLibrary, bookReserved);
    }
}
