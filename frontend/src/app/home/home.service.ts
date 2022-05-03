import { Observable } from "rxjs";
import { User } from "../model/user.model";

export interface HomeService {

    findUser(username: string): Observable<any>

    findAllUser(): Observable<any>
    
    deleteUser(user: any): Observable<any> 

}