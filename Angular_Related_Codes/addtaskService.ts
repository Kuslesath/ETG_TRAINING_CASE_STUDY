import {Injectable} from '@angular/core';
import { HttpClient} from "@angular/common/http";
import { TaskInterface } from '../TaskInterface';

@Injectable({ providedIn:'root' })

export class addtaskService{

        constructor(private httpClient : HttpClient) { }
       
        addPost (postD: TaskInterface) {
           return this.httpClient.post("http://localhost:8080/addtask", postD);
        }
    }