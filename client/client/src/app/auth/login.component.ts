import { HttpClient } from '@angular/common/http';
import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model';
import {AuthService} from "./auth.service"
@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit{

    user: User;

    constructor(private authService: AuthService, private http: HttpClient, private router: Router) {
    }

    ngOnInit() { 
      this.user ={username:'', password:'',email:''}
    }

    login(){
      this.authService.login(this.user.username, this.user.password).subscribe( res => {
      this.authService.redirectUrlAfterLogin();
      });
    }
}


