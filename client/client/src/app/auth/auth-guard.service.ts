import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, ActivatedRoute, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(public authService: AuthService, public router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): true | UrlTree {
    const url: string = state.url;
    return this.checkLogin(url);
  }

  //  canActivateChild( route: ActivatedRouteSnapshot, state: RouterStateSnapshot): true | UrlTree {
  //   return this.canActivate(route, state);
  // }

  checkLogin(url: string): true | UrlTree {
    if (this.authService.isLoggedIn()) { return true; }

    // Store the attempted URL for redirecting
    console.log('ur', url)
    this.authService.redirectUrl = url;

    // Redirect to the login page
    return this.router.parseUrl('/login');
  }
}