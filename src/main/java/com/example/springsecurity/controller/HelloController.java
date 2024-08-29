package com.example.springsecurity.controller;

import com.example.springsecurity.model.Users;
import com.example.springsecurity.repo.UserRepo;
import com.example.springsecurity.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    UserService service;

    @GetMapping("/")
    public String hello(HttpSession session){
        return "helloworld " + session.getId();
    }

    @GetMapping("whatdafaq")
    public String nigga(HttpSession session){
        return "suck this " + session.getId();
    }

    @PostMapping("register")
    public Users register(@RequestBody Users users){
        return service.saveUser(users);
    }
}
