import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators } from "@angular/forms"; 
import { Router } from '@angular/router';
import { TaskInterface } from '../TaskInterface';
import { searchService } from './searchService';

@Component({
  selector: 'app-track-task',
  templateUrl: './search.html',
  styleUrls: ['../dynamic-apicall.component.css']
})
export class searchComp implements OnInit {


  public task1!:TaskInterface[];
  form2!:any;
  key!:string;
  value!:string;
constructor(private ts:searchService, private router:Router) { }

ngOnInit(){
  this.form2=new FormGroup({
      key:new FormControl("",Validators.compose([Validators.required])),
      value:new FormControl("",Validators.compose([Validators.required]))
      });
}
onSubmit(user1:any)  {
  console.log(user1);
  if(user1.status==''){
      alert("Please Select one option from the list!");
  }
  else{
this.ts.search(user1.key,user1.value).subscribe(data=> this.task1 =data)
   
  }
}
onClick(){
  this.router.navigate(['/'])
}
onClick1(){
  this.router.navigate(['/home'])
}

}