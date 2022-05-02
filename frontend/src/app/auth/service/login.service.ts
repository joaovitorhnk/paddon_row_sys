import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, Router } from "@angular/router";
import { AuthService } from "../auth.service";

@Injectable({
    providedIn: 'root'
})
export class LoginService extends AuthService {

    public isAuthenticate = true;

    constructor() {
        super();
    }

    login(): boolean {

        if(this.isAuthenticate) {
            console.log('Fodão')
            return true;
        } else {
            console.log('Não deu')
            return false;
        }

    }

    

}