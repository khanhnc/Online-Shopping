package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user != null) {
            return user;
    }
    throw new UsernameNotFoundException("Username not found");
    }

    public User getUserProfile(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    public User registration(User user) {
        return this.userRepository.save(user);
    }

    public boolean checkUsernameUsed(String username) {
        User usedUser = userRepository.findByUsername(username);
        return usedUser != null;
    }

    public boolean checkEmailUsed(String email) {
        User usedUser = userRepository.findByEmail(email);
        return usedUser != null;
    }

}