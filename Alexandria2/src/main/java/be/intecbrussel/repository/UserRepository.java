package be.intecbrussel.repository;

import be.intecbrussel.model.user.Admin;
import be.intecbrussel.model.user.Member;
import be.intecbrussel.model.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    LocalDate dateOfJoiningLibrary = LocalDate.now();
    private List<User> userList  = new ArrayList<>();

    {
        userList.add(new Admin("Admin", "Admin", "Admin@Alexandria.org", "11",2000));
        userList.add(new Member("Deepika", "Aggarwala", "Deepika@Alexandria.org", "22", 2000));
        userList.add(new Member("Jonathan", "Deroo", "Jonathan@Alexandria.org", "33",2000));
        userList.add(new Member("Maxime", "Franquet", "Maxime@Alexandria.org", "44", 2000));
        userList.add(new Member("Mausam", "Tiwari", "Mausam@Alexandria.org", "55", 2000));
    }

    public List<User> getUserList(){
        return userList;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "dateOfJoiningLibrary=" + dateOfJoiningLibrary +
                ", userList=" + userList +
                '}';
    }
}
