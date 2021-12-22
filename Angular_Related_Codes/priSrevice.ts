import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http'

@Injectable({ providedIn: 'root' })

export class priService {

    constructor(private http:HttpClient) { }

    setPriority(a:string,b:string):Observable<any>{
      
        return this.http.get<boolean>("http://localhost:8080/setpriority/"+a+"/taskid/"+b);
    }
}