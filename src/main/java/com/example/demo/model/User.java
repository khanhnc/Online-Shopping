package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "table_user")
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    @Email
    @NotNull
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private  Set<Role> roles ;


    public User(){
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getPassword() { return this.password;}

    public String getUsername() { return this.username;}

    public void setEmail(String email) { this.email = email;}

    public String getEmail(){ return this.email;}

//    public void setRoles(Set<Role> roles) {this.roles = roles;}

//    public Set<Role> getRoles(){ return this.roles;}
}
