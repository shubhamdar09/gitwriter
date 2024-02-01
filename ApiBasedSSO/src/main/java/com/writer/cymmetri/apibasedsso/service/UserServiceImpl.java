package com.writer.cymmetri.apibasedsso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.writer.cymmetri.apibasedsso.model.User;
import com.writer.cymmetri.apibasedsso.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Integer addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user).getUserId();
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(Integer userId) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(userId);
		return optionalUser.orElse(null);
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);

	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

}