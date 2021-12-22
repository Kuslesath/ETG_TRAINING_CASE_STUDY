import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators } from "@angular/forms"; 
import { Router } from '@angular/router';
import { TaskInterface } from '../TaskInterface';
import { csService } from './csService';
@Component({
  selector: 'app-assigntask',
  templateUrl: './cs.html',
  styleUrls: ['../dynamic-apicall.component.css']
})
export class csComp implements OnInit {

  public tasks!:TaskInterface[];
  form!:any;
  taskid!:number;
  status!:string;
  status_changed_on!:Date;

  constructor(private cs:csService, private router:Router) { }

   ngOnInit(){

    this.form=new FormGroup({
      
        taskid:new FormControl("",Validators.compose([Validators.required])),
        status:new FormControl("",Validators.compose([Validators.required])),
        status_changed_on:new FormControl("",Validators.compose([Validators.required]))
       
    });
}
onSubmit(user1:any)  {
  console.log(user1);
  this.cs.cs(user1.taskid,user1.status,user1.status_changed_on).subscribe(data=>{ 
      if(data == true)
    {
      alert("Status of Task No "+user1.taskid+" has been updated");
        this.router.navigate(['/home']);
    }

    else
    {
    alert("Please enter Valid Credentials");
    }}
)
  
}
onClick(){
  this.router.navigate(['/'])
}
onClick1(){
  this.router.navigate(['/home'])
}
}