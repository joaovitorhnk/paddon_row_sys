import { Component, OnInit } from "@angular/core";
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
       this.service.findAllUser().subscribe(res => {
           console.log(res)
       })

       this.service.findUser("admin").subscribe(register => {
           console.log(register)
           this.service.deleteUser(register.id).subscribe(response => {
               console.log(response)
           })
       })
    }

    

}