import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
@Injectable({ providedIn: 'root' })

export class loginService {

    constructor(private http:HttpClient) { }

    login(a:string,b:string):Observable<any>{
        return this.http.get<boolean>("http://localhost:8080/uname/"+a+"/pwd/"+b);
    }
}