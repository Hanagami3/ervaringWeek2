package be.intecbrussel.utils;

import be.intecbrussel.model.book.Book;

public class ValidationTools {

    public boolean isValidBook(Book book)
    {
        // Example: Check if essential information is not null
        return  book.getBookIDNO() >= 0 &&
                book.getBookAuthor() != null &&
                book.getBookTitle()!= null &&
                //book.bookInLibrary != null &&
                book.getBookPublishYear() > 0 ;
    }
}
