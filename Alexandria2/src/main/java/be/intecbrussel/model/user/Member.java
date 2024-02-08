package be.intecbrussel.model.user;

import java.time.LocalDate;
import java.util.List;

public class Member extends User {


    public Member(String firstName, String lastName, String emailId, String password, int birthYear) {
        super(firstName, lastName, emailId, password, birthYear);
    }


    public List<Member> listOfAllMembersByDate(){



        return null;
    }
}
