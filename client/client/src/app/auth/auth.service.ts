import * as moment from "moment"; 
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http"
import { User } from "../model";
import { shareReplay, tap } from 'rxjs/operators';

@Injectable()
export class AuthService{   

    constructor(private http: HttpClient){}

    login(username: string, password:string) {
        return this.http.post<User>("/api/authenticate", {username, password})
        .pipe(
            tap(res => {
                this.setSession(res);
            }),
            shareReplay()
        )
    }

    setSession(authResult) {
        let expiresAt = moment().add(authResult.expDate,'second');
        localStorage.setItem('id_token', authResult.jwt);
        localStorage.setItem("expires_at", JSON.stringify(expiresAt.valueOf()) );
    }

    logout() {
        localStorage.removeItem("id_token");
        localStorage.removeItem("expires_at");
    }

    public isLoggedIn(){
        return moment().isBefore(this.getExpiration());
    }

    isLoggedOut(){
        return !this.isLoggedIn();
    }

    getExpiration() {
        let expiration = localStorage.getItem("expires_at");
        let expiresAt = JSON.parse(expiration);
        return moment(expiresAt);
    } 
}