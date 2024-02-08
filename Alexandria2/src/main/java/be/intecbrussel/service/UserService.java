package be.intecbrussel.service;

import be.intecbrussel.model.book.Book;
import be.intecbrussel.model.user.User;
import be.intecbrussel.repository.BookRepository;
import be.intecbrussel.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private UserRepository userRepository;
    private BookRepository bookRepository;
    private int userID;
    private List<User> users;

    public UserService(UserRepository userRepository, BookRepository bookRepository){
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.userID = 0;
    }

    public List<User> addUser(User user){
        if (userRepository.getUserList().contains(user)){
            throw new RuntimeException("animal already exist");
        }
        user.setUserId(userID);
        userRepository.getUserList().add(user);
        userID++;
        return userRepository.getUserList();
    }

    public boolean removerUser(User user){
        if (!userRepository.getUserList().contains(user)){
            return false;
        }
        userRepository.getUserList().remove(user);
        return true;
    }

    public String GetUserInfo(User user){
        return userRepository.toString();
    }

    public void ReservedBook(Book book){
        if(!bookRepository.getBookList().contains(book)){
            System.out.println("this book is not in the list");
        }
        else if(!book.isBookReserved()) {
                book.setBookReserved(true);
            }
        else
            System.out.println("the book is already reserved, try in a few weee");

    }

    public List<User> listAllMembersByDateOfJoining() {  //Jonathan

        List <User> sortedList= userRepository.getUserList();

        sortedList.sort(Comparator.comparing(user -> user.getDateOfJoiningLibrary()));

        return sortedList;
    }




    public void UpdateMemberInfo() {   //Jonathan


        Scanner myScanner = new Scanner(System.in);

        List<User> userList = userRepository.getUserList();

        //entering the ID
        System.out.println("\n\nPlease enter the member ID: ");
        Integer memberID = myScanner.nextInt();

        //checking there is only 1 member with the same ID

        List<User> allUsersWithSameID = userList.stream().filter(u -> u.getUserId() == memberID).toList();


        if (allUsersWithSameID.size() > 1) {
            System.out.println("Error! Multiple users with the same ID!!!");
            return;
        }
        if (allUsersWithSameID.size() < 1) {
            System.out.println("There is no member with ID number: " + memberID);
            return;
        }

        User userWithID = allUsersWithSameID.get(0);

        System.out.println(userWithID);

        //Menu with options

        boolean continueLoop = true;

        while (continueLoop) {

            System.out.println("Which information do you wish to change?");
            System.out.println("1. E-mail address\n2. Last name\n3.First Name\n4.Password\n5.Exit");

            int selection = 0;
            switch (selection) {
                case 1:
                    System.out.println("Enter new E-mail address: \n");
                    String email = myScanner.nextLine();
                    userWithID.setEmailId(email);
                    break;
                case 2:
                    System.out.println("Enter new last name: \n");
                    String name = myScanner.nextLine();
                    userWithID.setLastName(name);
                    break;
                case 3:
                    System.out.println("Enter new first name: \n");
                    String firstName = myScanner.nextLine();
                    userWithID.setFirstName(firstName);
                    break;
                case 4:
                    System.out.println("Enter new password: \n");
                    String password = myScanner.nextLine();
                    userWithID.setPassword(password);
                    break;

                default:
                    System.out.println("Goodbye");
                    return;
                //break;

            }
        }


        System.out.println("Is this correct?: Y/N \n" + userWithID);

        if (!myScanner.nextLine().toLowerCase().startsWith("y"))
            this.UpdateMemberInfo(); //if the librarian is not happy, the method is re-started.


        //update the main list


        myScanner.close();

    }

}
