package com.bmonish.springbootmongo.controllers;

import com.bmonish.springbootmongo.models.User;
import com.bmonish.springbootmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("v1/user")
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Optional<User> getUserById(@PathVariable("id") String id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PatchMapping
    public User updateUserById(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUserById(@PathVariable("id") String id) {
        userRepository.deleteById(id);
    }
}
