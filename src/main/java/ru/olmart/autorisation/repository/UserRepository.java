package ru.olmart.autorisation.repository;

import org.springframework.stereotype.Repository;
import ru.olmart.autorisation.model.Authorities;
import java.util.*;

@Repository
public class UserRepository {
    private Map<String, String> usersList = new HashMap<>();

    public UserRepository() {
        usersList.put("vlad", "123");
        usersList.put("mike", "qwerty");
        usersList.put("vlada", "1234");
        usersList.put("masha", "qwer");
    }
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authoritiesList = new ArrayList<>();
        if(user.equals("vlad") && usersList.get(user).equals(password)) {
            authoritiesList.add(Authorities.READ);
            authoritiesList.add(Authorities.WRITE);
            authoritiesList.add(Authorities.DELETE);
            return authoritiesList;
        }
        if (usersList.containsKey(user) && usersList.get(user).equals(password)) {
            authoritiesList.add(Authorities.READ);
            return authoritiesList;
        }
        return authoritiesList;
    }
}