import { Injectable } from "@angular/core";
import { User } from "src/app/model/user.model";
import { HomeService } from "../home.service";
import { HttpClient } from '@angular/common/http';
import { environment } from "src/environments/environment.prod";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class UserService implements HomeService {

    private baseUrl = "http://localhost:8080/users";

    constructor(
        private http: HttpClient
    ) {}


    deleteUser(user: any): Observable<any> {
        return this.http.delete(`${this.baseUrl}/delete/` + user);
    }

    findAllUser(): Observable<any> {
        return this.http.get(`${this.baseUrl}`);
    }

    findUser(username: string): Observable<any> {
        return this.http.get(`${this.baseUrl}/` + username)
    }
    
    
    
    
}