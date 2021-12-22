import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http'
import { TaskInterface } from "../TaskInterface";

@Injectable({ providedIn: 'root' })

export class trackservice {


    constructor(private http:HttpClient) { }

    
    track(a:string):Observable<TaskInterface[]>{
      
        return this.http.get<TaskInterface[]>("http://localhost:8080/status/"+a);
    }
}