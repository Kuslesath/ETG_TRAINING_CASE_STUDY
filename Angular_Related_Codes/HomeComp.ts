import {Component, OnInit} from '@angular/core';
import { loginService } from './loginservice';
import { UserInterface } from "./UserInterface";
import { FormGroup,FormControl,Validators } from "@angular/forms"; 
import { Router } from '@angular/router';

@Component({

    selector: 'home',
    templateUrl: './Home.html',
    styleUrls: ['./dynamic-apicall.component.css']

})

export class HomeComp implements OnInit {

    constructor(private router: Router){}

    ngOnInit(){}

    onClick(){
        this.router.navigate(['/'])
    }
    onClick1(){
        this.router.navigate(['/alltask'])
    }
    onClick2(){
        this.router.navigate(['/search'])
    }
    onClick3(){
        this.router.navigate(['/addtask'])
    }
    onClick4(){
        this.router.navigate(['/assigntask'])
    }
    onClick5(){
        this.router.navigate(['/setpri'])
    }
    onClick6(){
        this.router.navigate(['/track'])
    }
    onClick7(){
        this.router.navigate(['/cs'])
    }
    onClick8(){
        this.router.navigate(['/notes'])
    }
}