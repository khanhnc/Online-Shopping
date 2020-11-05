package com.example.demo.model;

import org.springframework.security.core.userdetails.UserDetails;

public class ClientUser implements UserDetails {
    private String username;
    private String email;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
