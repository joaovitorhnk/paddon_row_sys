import { Component, OnInit } from "@angular/core";
import { User } from "src/app/model/user.model";
import { HomeService } from "../home.service";
import { UserService } from "../services/user.service";

@Component({
    selector: 'app-home',
    templateUrl: '../templates/home.component.html',
    styleUrls: ['../styles/home.component.scss'],
})
export class HomeComponent implements OnInit {

    constructor(
        private service: UserService
    ) {}

    ngOnInit(): void {

    //   this.service.logout();
      
    }

    

}