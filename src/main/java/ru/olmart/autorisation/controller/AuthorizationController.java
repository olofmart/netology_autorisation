package ru.olmart.autorisation.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.olmart.autorisation.exception.InvalidCredentials;
import ru.olmart.autorisation.exception.UnauthorizedUser;
import ru.olmart.autorisation.model.Authorities;
import ru.olmart.autorisation.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {

    @Autowired
    private AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String resolveInvalidCredential(InvalidCredentials invalidCredentials) {
        return "Вы не ввели имя или пароль: " + invalidCredentials.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    ResponseEntity<String> resolveUnauthorizedUser(RuntimeException exception) {
        System.out.println(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
