import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http'
import { TaskInterface } from "./TaskInterface";

@Injectable({ providedIn: 'root' })

export class taskService {

    constructor(private http:HttpClient) { }

    getTasks(): Observable<TaskInterface[]> {
        return this.http.get<TaskInterface[]>("http://localhost:8080/alltask");
    }
}