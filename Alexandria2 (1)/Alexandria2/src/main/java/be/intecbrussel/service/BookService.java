package be.intecbrussel.service;

import be.intecbrussel.model.book.Book;
import be.intecbrussel.model.user.FindAndSortKeys;
import be.intecbrussel.model.user.User;
import be.intecbrussel.repository.BookRepository;
import be.intecbrussel.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookService {
    private BookRepository bookRepository;
    private UserRepository userRepository;
    Scanner  myScanner = new Scanner(System.in);
    private int bookId;
    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public void addBook(Book book) throws Exception
    {
        List<Book> bookList = bookRepository.getBookList();

        //List<Book> bookList = bookRepository.getBookList();

        if (book != null && isValidBook(book))
        {
            Book lastBookNoBeforeAdd = bookList.stream().max(Comparator.comparing(Book::getBookIDNO)).get();
            bookList.add(book);
            bookId =  lastBookNoBeforeAdd.getBookIDNO();  // get last largest Book ID no in the list
            book.setBookIDNO(bookId+1);   // increase 1 in last largest no to get unique ID of the book
            bookList.forEach(System.out::println);

        }
        else
        {
            throw new Exception("Kindly enter correct book info");
            // System.out.println("Unable to add the book. Check conditions.");
        }

    }
    private boolean isValidBook(Book book)
    {
        // Example: Check if essential information is not null
        return  book.getBookIDNO() != 0 &&
                book.getBookAuthor() != null &&
                book.getBookTitle()!= null && book.bookInLibrary != null && book.getBookPublishYear() > 0 ;
    }

    // method to control type of finding book
    public void findTypeControl(FindAndSortKeys findType) {
        switch (findType) {
            case ID: {
                System.out.println("Enter Book ID");
                int bookId = myScanner.nextInt();
                Optional<Book> foundBookByBookId = findBookByBookId(bookId);

                if (foundBookByBookId.isPresent()) {

                    System.out.println(foundBookByBookId.get());
                } else {
                    System.out.println("Book not found with given ID: ");
                }
                break;

            }

            case TITLE: {
                System.out.println("Enter Book Title");
                String bookTitle = myScanner.nextLine();
                List<Book> foundBookByBookTitle = findBookByBookTitle(bookTitle);

                if (!foundBookByBookTitle.isEmpty()) {
                    System.out.println("Books by " + bookTitle + ":");
                    foundBookByBookTitle.forEach(System.out::println);


                } else {
                    System.out.println("No books found for given: " + bookTitle);
                }
                break;
            }


            case AUTHOR: {
                System.out.println("Enter Book Author");
                String bookAuthor = myScanner.nextLine();
                List<Book> foundBookByBookAuthor = findBookByBookAuthor(bookAuthor);

                if (!foundBookByBookAuthor.isEmpty()) {
                    System.out.println("Books by " + bookAuthor + ":");
                    foundBookByBookAuthor.forEach(System.out::println);
                } else {
                    System.out.println("No books found for author: " + bookAuthor);
                }
                break;
            }
        }
    }

    public Optional<Book> findBookByBookId(int bookId)
    {
        List<Book> bookList = bookRepository.getBookList();
        return bookList.stream()
                .filter(book -> book.getBookIDNO()==bookId)
                .findFirst();
    }

    public List<Book> findBookByBookTitle(String bookTitle)
    {
        List<Book> bookList = bookRepository.getBookList();
        return bookList.stream()
                .filter(book -> book.getBookTitle().equalsIgnoreCase(bookTitle))
                .collect(Collectors.toList());
    }

    public List<Book> findBookByBookAuthor(String bookAuthor)
    {
        List<Book> bookList = bookRepository.getBookList();
        return bookList.stream()
                .filter(book -> book.getBookAuthor().equalsIgnoreCase(bookAuthor))
                .collect(Collectors.toList());
    }
    //Method to control sorting Type
    public void sortTypeControl(FindAndSortKeys sortKey)
    {
        switch (sortKey) {
            case AUTHOR:
            {
                List<Book> sortedList = sortBookByBookAuthor();
                sortedList.forEach(System.out::println);
                break;
            }
            case PUBLISHING_YEAR:
            {
                List<Book> sortedList = sortBookByPublishingYear();
                sortedList.forEach(System.out::println);
                break;
            }
        }
    }

    public List<Book> sortBookByBookAuthor()
    {
        List<Book> bookList = bookRepository.getBookList();
        return (bookList.stream().sorted(Comparator.comparing(Book::getBookAuthor)).collect(Collectors.toList()));
    }

    public List<Book> sortBookByPublishingYear()
    {
        List<Book> bookList = bookRepository.getBookList();
        return (bookList.stream().sorted(Comparator.comparing(Book::getBookPublishYear)).collect(Collectors.toList()));
    }

    public void updateBookInfo(int bookId) throws Exception
    {
        Scanner myScanner = new Scanner(System.in);
        List<Book> bookList = bookRepository.getBookList();
        Optional<Book> bookInfo = bookList.stream().filter(book-> book.getBookIDNO() == bookId).findFirst();
        if(bookInfo.isPresent())
        {
            System.out.println("Book Title : ");
            String bookTitle = myScanner.nextLine();
            System.out.println("Book Author : ");
            String bookAuthor = myScanner.nextLine();
            System.out.println("Book Publishing Year : ");
            int publishingYear = myScanner.nextInt();
            updateBook(bookId,bookTitle,bookAuthor,publishingYear);
        }
        else
        {
            System.out.println("Book not present");
        }
    }

    public void updateBook(int bookId, String bookTitle,String bookAuthor,int publishingYear) throws Exception {

        List<Book> bookList = bookRepository.getBookList();
        Book updateBookRecord = bookList.stream().filter(book -> book.getBookIDNO() == bookId).findFirst().get();
        if (bookTitle != null && bookAuthor != null && publishingYear > 0)
        {
            updateBookRecord.setBookTitle(bookTitle);
            updateBookRecord.setBookPublishYear(publishingYear);
            updateBookRecord.setBookAuthor(bookAuthor);
            System.out.println(updateBookRecord);
        }
        else {
            throw new Exception();
        }
    }

    public int countBooks()
    {
        List<Book> bookList = bookRepository.getBookList();
        return(bookList.size()) ;
    }

    public void reservedBook(Book book, User user){
        if(!bookRepository.getBookList().contains(book)){
            System.out.println("this book is not in the list");
        }
        else if(!book.isBookReserved()) {
            book.setBookReserved(true);
            book.setBookReservedBy(user);
        }
        else
            System.out.println("the book is already reserved, try in a few week");

    }
}
