package com.writer.cymmetri.apibasedsso.service;

import com.writer.cymmetri.apibasedsso.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


	public Integer addUser(User user);
	public List<User> getUsers();
	public User getUser(Integer userId);
	public void deleteUser(Integer userId);
	public void updateUser(User user);
	public User getUserByEmail(String email);
}
