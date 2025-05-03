package com.SpringDemo.Security.Controller;

import com.SpringDemo.Security.Model.User;
import com.SpringDemo.Security.Service.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceInterface service;

    public UserController(UserServiceInterface service) {
        this.service = service;
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<User> getAllUsers() {
//        return userRepo.findAll();
//    }

//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public User getUserById(@PathVariable Integer id) {
//        return userRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//    }
//
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return service.save(user);
    }
//
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
//        user.setId(id);
//        return userRepo.save(user);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteUser(@PathVariable Integer id) {
//        userRepo.deleteById(id);
//    }
}
