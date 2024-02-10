package be.intecbrussel.utils;

import be.intecbrussel.model.book.Book;
import be.intecbrussel.model.book.FindAndSortKeys;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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