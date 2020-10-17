import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { User } from '../model';
import {AuthService} from "./auth.service"
@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

    user: User = {username:'admin', password:'admin',email:'test'};

    constructor(private authService: AuthService, private http: HttpClient) {
      console.log("login workds")
    }

    login(){
      this.authService.login(this.user.username, this.user.password).subscribe(res=>{
        console.log("rep", res)
      });
    }
}


