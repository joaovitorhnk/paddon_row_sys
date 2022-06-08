import { Observable } from "rxjs";

export interface IAdminService {

    getAllUsers(): Observable<any>

}