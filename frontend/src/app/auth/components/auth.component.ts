import { Component, OnInit } from "@angular/core";
import { AuthService } from "../auth.service";
import { LoginService } from "../service/login.service";

@Component({
    selector: 'app-auth',
    templateUrl: '../templates/auth.component.html',
    providers: [ 
        {
            provide: AuthService, 
            useClass: LoginService
        }
    ]
})
export class AuthComponent implements OnInit {

    constructor(
        private service: AuthService
    ) {}

    ngOnInit(): void {
        this.service.login();
    }

}