package com.example.demo.controller;

import com.example.demo.model.AuthenticationRequest;
import com.example.demo.model.AuthenticationResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.until.JwtUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUntil jwtUntil;

    @RequestMapping(value="/checkUsername",method=RequestMethod.POST)
    public ResponseEntity<Boolean> checkUser(@RequestBody User data){
        return ResponseEntity.ok(userService.checkUsernameUsed(data.getUsername()));
    }

    @RequestMapping(value="/checkEmail",method=RequestMethod.POST)
    public ResponseEntity<Boolean> checkEmail(@RequestBody User data){
        return ResponseEntity.ok(userService.checkEmailUsed(data.getEmail()));
    }

    @RequestMapping(value="/hello",method=RequestMethod.GET)
    public String  hello(){
        return "hello";
    }

    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public ResponseEntity<User> signup(@RequestBody User user) {
        User savedUser = userService.save(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {
        try {
            UsernamePasswordAuthenticationToken authReq
                    = new UsernamePasswordAuthenticationToken( authenticationRequest.getUsername(),authenticationRequest.getPassword());
            authenticationManager.authenticate(authReq);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<String>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        } catch (AuthenticationException e ){
            return new ResponseEntity<String>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
        final User userDetails = userService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUntil.generateToken(userDetails);
        final Date expirationDate = jwtUntil.extractExpiration(jwt);
        return ResponseEntity.ok(new AuthenticationResponse(jwt, expirationDate.getTime()));
    }

}