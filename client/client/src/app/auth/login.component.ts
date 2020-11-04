import { HttpClient } from '@angular/common/http';
import { Route } from '@angular/compiler/src/core';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model';
import {AuthService} from "./auth.service"
@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

    user: User = {username:'', password:'',email:''};

    constructor(private authService: AuthService, private http: HttpClient,
      private route: Router) {
    }

    login(){
      console.log(this.user)
      this.authService.login(this.user.username, this.user.password).subscribe(res=>{
        console.log("rep", res)
        this.route.navigateByUrl("/profile");
      });
    }
}


