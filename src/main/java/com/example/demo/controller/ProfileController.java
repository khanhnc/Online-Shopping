package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class ProfileController {
    @Autowired
    UserService userService;
    @RequestMapping(value="/profile", method = RequestMethod.POST)
    public ResponseEntity<User> getProfile(Principal principal) {
        String loggedUsername = principal.getName();
        User user = userService.getUserProfile(loggedUsername);
        return new ResponseEntity<User>( user,HttpStatus.ACCEPTED);
    }


}