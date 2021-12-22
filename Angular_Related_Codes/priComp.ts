import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators } from "@angular/forms"; 
import { Router } from '@angular/router';
import { priService } from './priSrevice';

@Component({
  selector: 'app-update-example',
  templateUrl: './pri.html',
  styleUrls: ['../dynamic-apicall.component.css']
})
export class priComp implements OnInit {

    form2!:any;
    taskid!:number;
    priority!:string;

    constructor(private ts:priService,private router:Router){}

    ngOnInit(){
      this.form2=new FormGroup({
        taskid:new FormControl("",Validators.compose([Validators.required])),
        priority:new FormControl("",Validators.compose([Validators.required]))
      });
  }
  onSubmitpri(user1:any)  {
    console.log(user1);
  this.ts.setPriority(user1.priority,user1.taskid).subscribe(data=>{ 
    if(data == true)
  {
    alert("Priority for Task No "+user1.taskid+" has changed to "+user1.priority);
      this.router.navigate(['/home']);
  }

  else
  {
  alert("Please enter Valid Credentials");
  }})
     
    
  }
  onClick(){
    this.router.navigate(['/'])
}
onClick1(){
    this.router.navigate(['/home'])
}

}