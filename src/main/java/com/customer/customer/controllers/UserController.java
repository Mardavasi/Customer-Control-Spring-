package com.customer.customer.controllers;

import com.customer.customer.entities.User;
import com.customer.customer.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserServiceImp service;


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return service.getUser(id);


    }

    @GetMapping("/user")
    public List<User> getAllUser() {
        return service.getAllUsers();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        service.deleteUser(id);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
        service.addUser(user);

    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody User updateUser) {
        service.updateUser(id, updateUser);

    }

    @GetMapping("/user/search")
    public List<User> searchUser(@RequestParam(name = "email", required = false) String email,
                                         @RequestParam(name = "address", required = false) String address) {
        return service.searchUser(email, address);


    }
}
