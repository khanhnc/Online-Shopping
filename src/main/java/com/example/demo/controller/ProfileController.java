package com.example.demo.controller;

import com.example.demo.model.ClientUser;
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
    public ResponseEntity<ClientUser> getProfile(Principal principal) {
        String loggedUsername = principal.getName();
        User user = userService.getUserProfile(loggedUsername);
        ClientUser clientUser = new ClientUser();
        clientUser.setUsername(user.getUsername());
        clientUser.setEmail(user.getEmail());
        return new ResponseEntity<ClientUser>( clientUser,HttpStatus.ACCEPTED);
    }


}