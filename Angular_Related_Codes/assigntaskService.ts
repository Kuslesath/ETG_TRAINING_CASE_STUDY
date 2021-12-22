import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http'

@Injectable({ providedIn: 'root' })

export class AssignService {


    constructor(private http:HttpClient) { }

    
    assign(a:number,b:number):Observable<any>{
      
        return this.http.get<boolean>("http://localhost:8080/assigntaskto/"+b+"/taskid/"+a);
    }
}