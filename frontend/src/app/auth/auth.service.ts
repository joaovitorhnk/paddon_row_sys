import { Observable } from "rxjs";
import { Login, ResponseLogin } from "./model/login.model";

export abstract class AuthService {

    abstract login(login: Login): Observable<any>;

    abstract isAuthenticate(): any;

}