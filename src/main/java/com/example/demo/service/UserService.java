package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public void saveUser( User user){
        userRepository.save(user);
    }

    public User findUser(String username){
        return          userRepository.findByUsername(username);
    }

}
