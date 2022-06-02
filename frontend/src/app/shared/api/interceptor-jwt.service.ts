import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from 'src/app/auth/service/login.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private authService: LoginService) { }

    baseUrl = 'http://localhost:8080/'

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add auth header with jwt if user is logged in and request is to api url

        
        const token = this.authService.isAuthenticate();
        
        if (token) {
            request = request.clone({
                setHeaders: {
                    Authorization: `${token}`
                }
            });
        }

        return next.handle(request);
    }
}