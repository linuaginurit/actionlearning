package com.agungfAl.actionlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agungfAl.actionlearning.entity.User;
import com.agungfAl.actionlearning.repository.UserRepository;

@RestController
@RequestMapping(path = "/users")
public class UserController {
  @Autowired
  UserRepository repo;

  @GetMapping("")
    public List<User> getAllUser(){
        return repo.findAll();
    }

  @PostMapping("")
  public User addUser(User user){
        return repo.save(user);
    }

  @GetMapping("/{id}")
    public User getUserById(Long id){
        return repo.findById(id).get();
    }



}
