import { HttpClient, HttpResponse } from "@angular/common/http";
import { Inject, Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, Router } from "@angular/router";
import { BehaviorSubject, map, Observable, tap } from "rxjs";
import { environment } from "src/environments/environment";
import { AuthService } from "../auth.service";
import { Login, ResponseLogin } from "../model/login.model";

@Injectable({
    providedIn: 'root',
})
export class LoginService extends AuthService {

    public isLogged;
    private userSubject: BehaviorSubject<any>;
    public user: Observable<any> | undefined;
    
    isLogin = false;
    roleAs: string = ''

    constructor(
        private http: HttpClient,
        private router: Router,
    ) {
        super();
        this.isLogged = false;
        this.userSubject = new BehaviorSubject<any>(localStorage.getItem('token'));
        this.user = this.userSubject.asObservable();
    }

    public get userValue(): any {
        return this.userSubject.value;
    }


    login(login: Login): Observable<any> {
        return this.http.post<any>(`${environment.api_url}/api/auth/signing`, login)
        .pipe(
            map((res: ResponseLogin) => {
                localStorage.setItem('token', `${res.tokenType} ${res.accessToken}`)
                localStorage.setItem('role', res.role)
                return res;
            })
        )
    }

    isAuthenticate() {
        const token = localStorage.getItem('token')
        return token
    }

    logout() {
        localStorage.removeItem('token');
        this.router.navigate(['/login']);
    }

    

}