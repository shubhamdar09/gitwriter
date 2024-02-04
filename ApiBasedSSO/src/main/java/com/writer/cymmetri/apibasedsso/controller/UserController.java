package com.writer.cymmetri.apibasedsso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.writer.cymmetri.apibasedsso.model.User;
import com.writer.cymmetri.apibasedsso.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all") // http://localhost:8080/api/users/all
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/get/{userId}") // http://localhost:8080/api/users/get/2
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        Optional<User> userOptional = userService.getUser(userId);

        return userOptional.map(user -> ResponseEntity.ok(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
//    @GetMapping("/login")  // http://localhost:8080/api/users/login
//    public String showLoginPage() {
//        return "Login";
//    }

    @PostMapping("/add") // http://localhost:8080/api/users/add
    public ResponseEntity<String> addUser(@RequestBody User user) {
        Integer userId = userService.addUser(user);
        String successMessage = "User added successfully with ID: " + userId;
        return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);
    }


    @DeleteMapping("/delete/{userId}") // http://localhost:8080/api/users/delete/5
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update") // http://localhost:8080/api/users/
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> userOptional = userService.getUserByEmail(email);

        return userOptional.map(user -> ResponseEntity.ok(user))
                .orElseGet(() -> ResponseEntity.notFound().build());

        
    }}
