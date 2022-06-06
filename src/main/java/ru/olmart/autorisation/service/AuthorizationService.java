package ru.olmart.autorisation.service;

import org.springframework.stereotype.Service;
import ru.olmart.autorisation.exception.InvalidCredentials;
import ru.olmart.autorisation.exception.UnauthorizedUser;
import ru.olmart.autorisation.model.Authorities;
import ru.olmart.autorisation.repository.UserRepository;
import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}