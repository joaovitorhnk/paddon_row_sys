import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from 'src/app/auth/service/login.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private authService: LoginService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
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