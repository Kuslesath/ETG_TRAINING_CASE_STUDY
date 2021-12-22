import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http'
import { TaskInterface } from "../TaskInterface";

@Injectable({ providedIn: 'root' })

export class searchService {


    constructor(private http:HttpClient) { }

    
   search(a:string,b:string):Observable<TaskInterface[]>{
      
        return this.http.get<TaskInterface[]>("http://localhost:8080/"+a+"/"+b);
    }
}