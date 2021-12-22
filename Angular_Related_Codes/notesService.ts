import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })

export class notesservice {


    constructor(private http:HttpClient) { }

    
    notes(a:string,b:number):Observable<any>{
      
        return this.http.get<boolean>("http://localhost:8080/addnotes/"+a+"/taskid/"+b);
    }
    bookmark(a:string,b:number):Observable<any>{
        console.log(a);
        return this.http.get<boolean>("http://localhost:8080/ibm/"+a+"/taskid/"+b);
    }
}