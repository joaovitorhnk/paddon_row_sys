import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { Interceptor } from "src/app/shared/api/interceptor.service";
import { AuthService } from "../auth.service";
import { Login, ResponseLogin } from "../model/login.model";
import { LoginService } from "../service/login.service";

@Component({
    selector: 'app-login',
    templateUrl: '../templates/login.component.html',
    styleUrls: ['../styles/login.component.scss'],
    providers: [
        {
            provide: AuthService,
            useClass: LoginService
        }
    ]
})
export class LoginComponent {

    form: FormGroup

    constructor(
        private service: AuthService,
        private _buildForm: FormBuilder,
        private route: Router,
        private interceptor: Interceptor
    )
    {
        this.form = this._buildForm.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        })
    }

    onSubmit(form: FormGroup) {

        const login: Login = {
            username: form.controls['username'].value,
            password: form.controls['password'].value,
        }

        this.service.login(login).subscribe((res: ResponseLogin) => {
            const is = this.service.isAuthenticate()
            console.log(is)
        })

    }
    

}