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

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService customUserDetailsService;
    @Autowired
    private JwtUntil jwtUntil;

    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public ResponseEntity<User>  signup() {

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
        final UserDetails userDetails = customUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUntil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}