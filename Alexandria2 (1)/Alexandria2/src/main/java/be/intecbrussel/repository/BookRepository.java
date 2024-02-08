package be.intecbrussel.repository;


import be.intecbrussel.model.book.*;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> bookList  = new ArrayList<>();
    {
        bookList.add(new ChildrenBooks(1234, "Diary of Wimpy Kid", "Jeff Kinney" , 2023, true, false));
        bookList.add(new ChildrenBooks(2235, "HarryPotter and the Philosphers", "J.K.Rowling" , 1997, true, false));
        bookList.add(new ChildrenBooks(3236, "Good night Moon", "Margaret Wise Brown" , 1947, true, false));
        bookList.add(new FictionBooks(4236, "The Great Gatsby", "F.Scott Fitzgerald" , 1925, true, false));
        bookList.add(new FictionBooks(3436, "The Alchemist", "Paulo Coelho" , 1947, true, false));
        bookList.add(new FictionBooks(3296, "To kill a mocking bird", "Harper Lee" , 1960, true, false));
        bookList.add(new NonFictionBooks(1276, "In Cold Blood", "Truman Copote" , 1965, true, false));
        bookList.add(new NonFictionBooks(8236, "A Brief History of Time", "Stephen Hawkings" , 1988, true, false));
        bookList.add(new NonFictionBooks(3276, "Into Thin Air", "John Krakower" , 1997, true, false));
        bookList.add(new OtherBooks(9023, "I am Malala", "Christina Lamb" , 2013, true, false));
        bookList.add(new OtherBooks(9023, "The Happiest Man on Earth", "Eddie Jalem" , 2020, true, false));


    }

    public List<Book> getBookList() {
        return bookList;
    }
}
