import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, Router } from "@angular/router";
import { AuthService } from "../auth.service";

@Injectable({
    providedIn: 'root'
})
export class LoginService extends AuthService {

    public isAuthenticate = false;

    constructor(
        private route: Router,
        private state: ActivatedRouteSnapshot 
    ) {
        super();
    }

    login(): boolean {

        if(this.isAuthenticate) {
            console.log('Fodão')
            return true;
        } else {
            console.log('Não deu')
            console.log(this.state.paramMap);
            this.route.navigateByUrl('/home/login');
            return false;
        }

    }

    

}