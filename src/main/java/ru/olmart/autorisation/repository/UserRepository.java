package ru.olmart.autorisation.repository;

import org.springframework.stereotype.Repository;
import ru.olmart.autorisation.model.Authorities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        return ...;
    }
}