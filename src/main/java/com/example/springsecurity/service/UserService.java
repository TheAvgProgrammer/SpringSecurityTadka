package com.example.springsecurity.service;

import com.example.springsecurity.model.Users;
import com.example.springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users saveUser(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }
}
