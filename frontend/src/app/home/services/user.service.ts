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

    private baseUrl = "http://localhost:8080/api/users";

    constructor(
        private http: HttpClient
    ) {}

    findAllUser(): Observable<any> {
        return this.http.get(`${this.baseUrl}`);
    }

    findUser(): User {
        throw new Error("Method not implemented.");
    }
    
    
    
}