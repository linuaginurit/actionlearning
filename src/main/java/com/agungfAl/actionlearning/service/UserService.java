package com.agungfAl.actionlearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.agungfAl.actionlearning.entity.User;
import com.agungfAl.actionlearning.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserService implements UserDetailsService {
  @Autowired
    PasswordEncoder encoder;

  @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User simpanUser(User user){
      log.info("creating user",user);
      //modifikasi data password
      user.setPassword(encoder.encode(user.getPassword()));
      return userRepository.save(user);
  }

  
}
