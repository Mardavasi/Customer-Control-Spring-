package com.customer.customer.services;

import com.customer.customer.entities.User;

import java.util.List;

public interface UserService {

    User getUser(Integer id);
    List<User> getAllUsers();
    void deleteUser(Integer id);
    void addUser(User user);
    void updateUser(Integer id, User updateUser);
    List<User> searchUser(String email, String address);
}
