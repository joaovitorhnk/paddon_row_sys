import { Injectable } from "@angular/core";
import { User } from "src/app/model/user.model";
import { HomeService } from "../home.service";
import { HttpClient } from '@angular/common/http';
import { environment } from "src/environments/environment.prod";
import { Observable } from "rxjs";
import { Router } from "@angular/router";

@Injectable({
    providedIn: 'root'
})
export class UserService implements HomeService {


    constructor(
        private http: HttpClient,
        private router: Router
    ) {}


    logout(): void {
        localStorage.clear();
        this.router.navigateByUrl('login');
    }


    deleteUser(user: any): Observable<any> {
        return this.http.delete(`${environment.api_url}/delete/` + user);
    }

    findAllUser(): Observable<any> {
        return this.http.get(`${environment.api_url}`);
    }

    findUser(username: string): Observable<any> {
        return this.http.get(`${environment.api_url}/` + username)
    }
    
    
    
    
}