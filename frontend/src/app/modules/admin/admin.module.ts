import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { InterceptorModule } from "src/app/shared/api/interceptor.module";
import { AdminRoutingModule } from "./admin-routing.module";
import { AdminComponent } from "./components/admin.component";
import { AdminService } from "./services/admin.service";

@NgModule({

    declarations: [
        AdminComponent
    ],
    imports: [
        AdminRoutingModule,
        CommonModule,
        HttpClientModule,
        InterceptorModule
    ],
    providers: [
        AdminService
    ]

})
export class AdminModule {}