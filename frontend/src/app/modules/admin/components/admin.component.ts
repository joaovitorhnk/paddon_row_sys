import { HttpResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Subject } from "rxjs";
import { IUserResponse } from "src/app/model/users-response.model";
import { IAdminService } from "../admin-interface";
import { AdminService } from "../services/admin.service";

@Component({
    selector: 'app-admin',
    templateUrl: '../templates/admin.component.html'
})
export class AdminComponent implements OnInit {

    users: Array<IUserResponse> = [];

    constructor(
        private service: AdminService
    ) {}

    ngOnInit(): void {
        this.service.getAllUsers().subscribe((response: HttpResponse<any>) => {
            if(response.status === 200) {
                this.users = response.body
            }
        })
    }

}