package be.intecbrussel;

import be.intecbrussel.model.book.Book;
import be.intecbrussel.model.book.ChildrenBooks;
import be.intecbrussel.model.user.FindAndSortKeys;
import be.intecbrussel.model.user.Member;
import be.intecbrussel.model.user.User;
import be.intecbrussel.repository.BookRepository;
import be.intecbrussel.repository.UserRepository;
import be.intecbrussel.service.BookService;
import be.intecbrussel.service.UserService;

import java.util.Scanner;

public class MainLibraryApp {


    static BookRepository bookRepository = new BookRepository();
    static UserRepository userRepository = new UserRepository();
    static UserService userService = new UserService(userRepository, bookRepository);
    static BookService bookService = new BookService(bookRepository, userRepository);

    static Scanner myScanner = new Scanner(System.in);


    public static void main(String[] args) throws Exception {

        /*User member = new Member("Deepika", "Aggarwala", "Deepika@Alexandria.org", "22", "2000");
        User member1 = new Member("Max", "Fra", "Deepika@Alexandria.org", "22", "2000");

        System.out.println("Welcome to Alexendria.");
        System.out.println();
        System.out.println("Sign in");
        userRepository.addUser(member);
        userRepository.addUser(member1);
        System.out.println(member.getDateOfJoiningLibrary());


        System.out.println(bookService.findBookByBookAuthor("Jeff Kinney"));

        System.out.println(userService.listAllMembersByDateOfJoining());

        Book book = new ChildrenBooks(1234, "Diary of Wimpy Kid", "Jeff Kinney", 2023, true, false);
        Book book1 = new ChildrenBooks(2235, "HarryPotter and the Philosphers", "J.K.Rowling", 1997, true, false);

        bookService.addBook(book);
        bookService.addBook(book1);

        bookService.reservedBook(book, member1);
        bookService.reservedBook(book1, member);

        System.out.println(userRepository.getUserList());
        userService.removerUserByName("Deepika", "Aggarwala");
        userService.removerUserByID(5);

        System.out.println(userRepository.getUserList());

        System.out.println(userService.InfoUserByID(3));
        System.out.println(userService.InfoUserByName("Max", "Fra"));
        addUser();*/

        char ans = 'y';
        Scanner myScanner = new Scanner(System.in);
        FindAndSortKeys findAndSortKeys;
        System.out.println("Welcome to Alexendria.");
        System.out.println("Enter your status admin/user");
        String status = myScanner.nextLine().toLowerCase();
        do {
            System.out.println("Kindly choose the method you want to perform");
            switch (status) {
                case "admin": {
                    System.out.println("1.Add Book");
                    System.out.println("2.Find Book");
                    System.out.println("3.Remove Book");
                    System.out.println("4.Sort Book");
                    System.out.println("5.update Book Record");
                    System.out.println("6.Count Book");
                    System.out.println("7.Issue Book");
                    System.out.println("8.Renew Book");
                    System.out.println("9.Return Book");
                    System.out.println("9.Browse Books");
                    System.out.println("10. Add Member");
                    System.out.println("11.Remove Member");
                    System.out.println("12.Search Member");
                    System.out.println("13. Update member info");
                    System.out.println("14.List Member");
                    System.out.println("15. Send warning");
                    System.out.println("16.Exit");
                    break;
                }
                case "member": {
                    System.out.println("17.Find Book");
                    System.out.println("18.Browse member info");
                    System.out.println("19.Browse Book");
                    System.out.println("20.Reserve Book");
                    System.out.println("21.Exit");
                    break;
                }
                default: {
                    System.out.println("Enter valid choice");
                }

            }

            System.out.println("Kindly Enter your choice");
            int choice = myScanner.nextInt();
            switch (choice) {
                case 1: {
                    try {
                        Book childrenBook = new ChildrenBooks(0, "The Lion Inside", "Rachel Bright", 2016, true, false);
                        bookService.addBook(childrenBook);
                    } catch (Exception e) {
                        System.out.println("Book info can not be null");
                    }
                    break;

                }
                case 2: {
                    System.out.println("How do you want to find a book Book Title/ Book Author/Book No");
                    System.out.println("Enter your choice");
                    System.out.println("1. Book Title");
                    System.out.println("2. Book Author");
                    System.out.println("3. Book No");
                    choice = myScanner.nextInt();
                    switch (choice) {
                        case 1: {
                            findAndSortKeys = FindAndSortKeys.TITLE;
                            bookService.findTypeControl(findAndSortKeys);
                            break;
                        }
                        case 2: {
                            findAndSortKeys = FindAndSortKeys.AUTHOR;
                            bookService.findTypeControl(findAndSortKeys);
                            break;
                        }
                        case 3: {
                            findAndSortKeys = FindAndSortKeys.ID;
                            bookService.findTypeControl(findAndSortKeys);
                            break;
                        }
                        default: {
                            System.out.println("Invalid choice");
                            break;

                        }
                    }
                }
                case 4: {
                    //Sort method
                    System.out.println("How do you want to sort books Book Author/ Publishing year");
                    System.out.println("Enter your choice");
                    System.out.println("1. Book Author");
                    System.out.println("2. Publishing Year");
                    choice = myScanner.nextInt();
                    switch (choice) {
                        case 1: {
                            findAndSortKeys = FindAndSortKeys.AUTHOR;
                            bookService.sortTypeControl(findAndSortKeys);
                            System.out.println("List Sorted");
                            break;
                        }
                        case 2: {
                            findAndSortKeys = FindAndSortKeys.PUBLISHING_YEAR;
                            bookService.sortTypeControl(findAndSortKeys);
                            System.out.println("List Sorted");
                            break;
                        }

                        default: {
                            System.out.println("Invalid choice");
                            break;

                        }
                    }
                }
                case 5: {
                    //Update book Record
                    System.out.println("Enter book Id to update info");
                    int bookNo = myScanner.nextInt();
                    try {
                        bookService.updateBookInfo(bookNo);
                        System.out.println("Info updated");
                    } catch (Exception e) {
                        System.out.println("Book info can not be null");
                    }
                    break;
                }
                case 6: {
                    //count books method
                    int countOfBooks = bookService.countBooks();
                    System.out.println("Total no of books are   " + countOfBooks);
                    break;
                }
                case 10: addUser();
                case 11: removeUser();
                case 13: getUserInfo();
                //case 20: bookService.reservedBook();

                System.out.println("Do you want to continue again (y/n)");
                ans = myScanner.next().charAt(0);
            }

        } while (ans == 'y' || ans == 'Y');

    }



    static Scanner scanner = new Scanner(System.in);

    private static void addUser() {
        System.out.println("voer the data van de gebruiken in:");
        System.out.println("Voornaam: ");
        String firstNameInput = scanner.nextLine();
        System.out.println("Achternaam: ");
        String lastNameInput = scanner.nextLine();
        System.out.println("Email: ");
        String EmailInput = scanner.nextLine();
        System.out.println("Geboortejaar: ");
        String birthDate = scanner.nextLine();
        userService.addUser(firstNameInput, lastNameInput, EmailInput, "1234", birthDate);
        scanner.close();
    }

    private static void removeUser(){
        System.out.println("1: Get User by name\n" +
                "2: GetUser by ID" );
        String input = scanner.nextLine();
        if (input.equals("1")){
            System.out.println("Voornaam: ");
            String firstNameInput = scanner.nextLine();
            System.out.println("Achternaam: ");
            String lastNameInput = scanner.nextLine();
            userService.removerUserByName(firstNameInput, lastNameInput);
        } else if (input.equals("2")) {
            System.out.println("UserId:");
            int userId = scanner.nextInt();
            userService.removerUserByID(userId);
        }else {
            System.out.println("slecht invoer");
        }
    }

    private static void getUserInfo(){
        System.out.println("1: Get User by name\n" +
                "2: GetUser by ID" );
        String input = scanner.nextLine();
        if (input.equals("1")){
            System.out.println("Voornaam: ");
            String firstNameInput = scanner.nextLine();
            System.out.println("Achternaam: ");
            String lastNameInput = scanner.nextLine();
            System.out.println(userService.InfoUserByName(firstNameInput, lastNameInput));
        } else if (input.equals("2")) {
            System.out.println("UserId:");
            int userId = scanner.nextInt();
            System.out.println(userService.InfoUserByID(userId));
        } else {
            System.out.println("slecht invoer");
        }
    }

}
