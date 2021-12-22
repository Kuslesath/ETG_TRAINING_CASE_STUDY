import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { UserInterface } from "../UserInterface";

@Injectable({
    providedIn: 'root'
})

export class getuserService{

        constructor(private httpClient : HttpClient) {

        }

        getTasks(): Observable<UserInterface[]> {
            return this.httpClient.get<UserInterface[]>("http://localhost:8080/allusers");
        }
    }