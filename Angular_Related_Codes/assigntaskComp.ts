import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators } from "@angular/forms"; 
import { Router } from '@angular/router';
import { TaskInterface } from '../TaskInterface';
import { AssignService } from './assigntaskService';
import { getuserService } from '../addtask/getuserService';
import { UserInterface } from "../UserInterface";
@Component({
  selector: 'app-assigntask',
  templateUrl: './assigntask.html',
  styleUrls: ['../dynamic-apicall.component.css']
})
export class AssigntaskComponent implements OnInit {

  public tasks!:TaskInterface[];
  form!:any;
  taskid!:number;
  ownerid!:number;
  public users!:UserInterface[];

  constructor(private as:AssignService, private router:Router,private us:getuserService) { }

   ngOnInit(){

    this.us.getTasks().subscribe(data=>this.users=data);
    this.form=new FormGroup({
      
        taskid:new FormControl("",Validators.compose([Validators.required])),
        ownerid:new FormControl("",Validators.compose([Validators.required]))
        
       
    });
}
onSubmitas(user1:any)  {
  console.log(user1);
  this.as.assign(user1.taskid,user1.ownerid).subscribe(data=>{ 
      if(data == true)
    {
      alert("Task No "+user1.taskid+" assigned to User Id "+user1.ownerid);
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