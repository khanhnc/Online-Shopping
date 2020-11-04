package com.example.demo.controller;

import com.example.demo.model.AuthenticationRequest;
import com.example.demo.model.AuthenticationResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.until.JwtUntil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;

@RestController
public class ProfileController {
    @Autowired
    UserService userService;
    @RequestMapping(value="/profile", method = RequestMethod.POST)
    public ResponseEntity<User> getProfile(Principal principal) {
        String loggedUsername = principal.getName();
        return new ResponseEntity<User>( userService.getUserProfile(loggedUsername),HttpStatus.ACCEPTED);
    }


}