import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators } from "@angular/forms"; 
import { Router } from '@angular/router';
import { TaskInterface } from '../TaskInterface';
import { trackservice } from './trackService';

@Component({
  selector: 'app-track-task',
  templateUrl: './track.html',
  styleUrls: ['../dynamic-apicall.component.css']
})
export class TrackTaskComponent implements OnInit {


  public tasks!:TaskInterface[];
  form2!:any;
  status!:string;
constructor(private ts:trackservice, private router:Router) { }

ngOnInit(){
  this.form2=new FormGroup({
      status:new FormControl("",Validators.compose([Validators.required]))

      });
}
onSubmit(user1:any)  {
  console.log(user1);
  if(user1.status==''){
      alert("Please Select one option from the list!");
  }
  else{
this.ts.track(user1.status).subscribe(data=> this.tasks =data)
   
  }
}
onClick(){
  this.router.navigate(['/'])
}
onClick1(){
  this.router.navigate(['/home'])
}

}