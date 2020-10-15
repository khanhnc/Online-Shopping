package com.example.demo.model;

import java.util.Date;

public class AuthenticationResponse {

    private final String jwt;
    private final Long expDate;

    public AuthenticationResponse(String jwt, Long expDate) {
        this.jwt = jwt;
        this.expDate = expDate;
    }

    public String getJwt() {
        return jwt;
    }

    public Long getExpDate() {
        return expDate;
    }

}
