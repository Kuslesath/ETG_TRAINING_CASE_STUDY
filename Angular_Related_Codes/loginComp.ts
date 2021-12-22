import {Component, OnInit} from '@angular/core';
import { loginService } from './loginservice';
import { UserInterface } from "./UserInterface";
import { FormGroup,FormControl,Validators } from "@angular/forms"; 
import { Router } from '@angular/router';
@Component({

    selector: 'login',
    templateUrl: './login.html',
    styleUrls: ['./dynamic-apicall.component.css']

})

export class loginComp implements OnInit {

    public users!:UserInterface[];
    
  form:any;
  uname!:string;
  pwd!:string;
    constructor(private ts:loginService,private router: Router){}


    ngOnInit(){
        this.form=new FormGroup({
            uname:new FormControl("",Validators.compose([Validators.required])),
            pwd:new FormControl("",Validators.compose([Validators.required])),
        });
    }

    onSubmit(user1:any)  {
        console.log(user1);
     this.ts.login(user1.uname,user1.pwd).subscribe(data=>{ 
        if(data == true)
        {
            console.log(data);
            this.router.navigate(['/home']);
        }
    
        else
        {
        alert("Please enter Valid Credentials");
        this.router.navigate(['/']);
        }
    });
    }
    
    signup(){
        this.router.navigate(['/signup'])
    }
}