package com.SpringDemo.Security.Controller;

import com.SpringDemo.Exceptions.CustomResponse;
import com.SpringDemo.Security.Model.User;
import com.SpringDemo.Security.Service.JwtServiceInterface;
import com.SpringDemo.Security.Service.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceInterface service;

    private final JwtServiceInterface jwtService;

    private final AuthenticationManager authenticationManager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(@RequestBody User user)  {

        User createdUser = null;

            createdUser = service.save(user);

        return  ResponseEntity.ok(
                new CustomResponse(
                        "2025",
                        "User created successfully",
                        createdUser
                )
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        // authenticate the user using the AuthenticationManager
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        // check if authentication was successful

        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(

                    new CustomResponse(
                            "200",
                            "Login successful",
                            jwtService.generateToken(username))
            );

        }else {
            return new ResponseEntity<>(
                    new CustomResponse(
                            "400",
                            "Invalid username or password",
                            null
                    ),HttpStatus.UNAUTHORIZED
            );
        }



    }

}
