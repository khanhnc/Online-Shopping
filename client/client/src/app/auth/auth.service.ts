import * as moment from "moment"; 
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http"
import { User } from "../model";
import { shareReplay, tap } from 'rxjs/operators';

@Injectable()
export class AuthService{

    constructor(private http: HttpClient){}

    login(username: string, password:string) {
        return this.http.post<User>("http://localhost:8080/login", {username, password})
        .pipe(
            tap(res => this.setSession),
            shareReplay()
        )
    }

    setSession(authResult) {
        const expiresAt = moment().add(authResult.expDate,'second');

        localStorage.setItem('id_token', authResult.idToken);
        localStorage.setItem("expires_at", JSON.stringify(expiresAt.valueOf()) );
    }
}