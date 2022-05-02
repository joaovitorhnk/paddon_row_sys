import { Observable } from "rxjs";
import { User } from "../model/user.model";

export interface HomeService {

    findUser(): User

    findAllUser(): Observable<any>
    

}