import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuardService } from './auth/auth-guard.service';
import { LoginComponent } from './auth/login.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  { 
    path: 'profile',
    component: ProfileComponent,
    canActivate: [AuthGuardService] 
  },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
