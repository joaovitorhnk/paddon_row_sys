import { NgModule } from '@angular/core';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { Interceptor } from './interceptor.service';
import { JwtInterceptor } from './interceptor-jwt.service';
import { ErrorInterceptor } from './interceptor-error.service';

@NgModule({
 providers: [
        Interceptor,
        JwtInterceptor,
        ErrorInterceptor,
        {
            provide: HTTP_INTERCEPTORS,
            useClass: Interceptor,
            multi: true,
        },
        { 
            provide: HTTP_INTERCEPTORS, 
            useClass: JwtInterceptor, 
            multi: true 
        },
        { 
            provide: HTTP_INTERCEPTORS, 
            useClass: ErrorInterceptor, 
            multi: true },
    ],
})
export class InterceptorModule {}