import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { IAdminService } from "../admin-interface";

@Injectable({
    providedIn: 'root'
})
export class AdminService implements IAdminService {

    constructor(
        private http: HttpClient
    ) {}

    getAllUsers(): Observable<any> {
        return this.http.get<any>(`${environment.api_url}/users`, {
            observe: 'response'
        })
    }

    
}