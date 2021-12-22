import {Component, OnInit} from '@angular/core';
import { taskService } from './taskService';
import { TaskInterface } from './TaskInterface';
import { Router } from '@angular/router';

@Component({

    selector: 'dynamicapp1',
    templateUrl: './task.html',
    styleUrls: ['./dynamic-apicall.component.css']
})

export class taskComp implements OnInit {

    public task1!:TaskInterface[];
    constructor(private ts:taskService,private router: Router){}

    ngOnInit()  {
     this.ts.getTasks().subscribe(data=>this.task1=data);
    }
    onClick(){
        this.router.navigate(['/'])
    }
    onClick1(){
        this.router.navigate(['/home'])
    }
}