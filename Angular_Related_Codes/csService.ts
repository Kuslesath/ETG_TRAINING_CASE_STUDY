import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http'

@Injectable({ providedIn: 'root' })

export class csService {


    constructor(private http:HttpClient) { }

    
    cs(a:number,b:string,c:Date):Observable<any>{
      
        return this.http.get<boolean>("http://localhost:8080/taskid/"+a+"/status/"+b+"/date/"+c);
    }
}