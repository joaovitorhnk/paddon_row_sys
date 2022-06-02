import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';
import { LoginService } from './service/login.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './components/login.component';
import { RouterModule } from '@angular/router';
import { InterceptorModule } from '../shared/api/interceptor.module';
import { environment } from 'src/environments/environment';


@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    InterceptorModule
  ],
})
export class AuthModule { }
