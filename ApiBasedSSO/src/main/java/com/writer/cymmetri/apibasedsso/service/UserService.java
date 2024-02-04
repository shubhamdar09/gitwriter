package com.writer.cymmetri.apibasedsso.service;

import com.writer.cymmetri.apibasedsso.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Integer addUser(User user);

    List<User> getUsers();

    Optional<User> getUser(Integer userId);

    void deleteUser(Integer userId);

    void updateUser(User user);

    Optional<User> getUserByEmail(String email);
}
