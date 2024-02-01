package com.writer.cymmetri.apibasedsso.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.writer.cymmetri.apibasedsso.model.User;
import com.writer.cymmetri.apibasedsso.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/getAll") // http://localhost:8080/api/users/getAll
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/get/{userId}") // http://localhost:8080/api/users/get/2
	public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
		User user = userService.getUser(userId);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add") // http://localhost:8080/api/users/add
	public ResponseEntity<Integer> addUser(@RequestBody User user) {
		Integer userId = userService.addUser(user);
		// String message = "User added successfully with userId: " +userId;
		return ResponseEntity.ok(userId);
	}
	@DeleteMapping("/delete/{userId}")//http://localhost:8080/api/users/delete/5
	public ResponseEntity<Void> deleteUserById(@PathVariable Integer userId){
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/update")//http://localhost:8080/api/users/update
	public ResponseEntity<Void> updateUser(@RequestBody User user){
		userService.updateUser(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/getByEmail/{email}")//http://localhost:8080/api/users/getByEmail/shubhamdarshanwar02@gmail.com
	public ResponseEntity<User> getUserByEmail(@PathVariable String email){
		User user =userService.getUserByEmail(email);
		if(user!=null) {
			return new ResponseEntity<>(user,HttpStatus.OK);
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}

}
