package com.agungfAl.actionlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agungfAl.actionlearning.entity.Role;
import com.agungfAl.actionlearning.repository.RoleRepository;


@RestController
public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/roles")
    List<Role> all() {
        return roleRepository.findAll();
    }
    
}
