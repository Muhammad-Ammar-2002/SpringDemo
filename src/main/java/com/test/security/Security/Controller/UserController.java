package com.test.security.Security.Controller;

import com.test.security.Exceptions.DuplicateRecordException;
import com.test.security.Security.Model.User;
import com.test.security.Security.Service.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceInterface service;

    public UserController(UserServiceInterface service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@RequestBody User user)  {

        User createdUser = null;

            createdUser = service.save(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}
