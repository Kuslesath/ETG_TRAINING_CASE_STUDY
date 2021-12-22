import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { UserInterface } from "./UserInterface";

@Injectable({
    providedIn: 'root'
})

export class signupService{
     postUrl: string = "http://localhost:8080/adduser";

    httpOptions = {
        headers : new HttpHeaders({
            'Content-Type': 'application/json' , 'Authorization': 'my-auth-token'})
        };

        constructor(private httpClient : HttpClient) {

        }

        addPost(postD: UserInterface) {
            return this.httpClient.post(this.postUrl, postD, this.httpOptions);
        }
    }