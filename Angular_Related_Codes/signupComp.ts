import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators } from "@angular/forms"; 
import { UserInterface } from './UserInterface';
import { signupService } from './signupSerivce';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-user',
  templateUrl: './signup.html',
  styleUrls: ['./dynamic-apicall.component.css']
})
export class signupComp implements OnInit {

  form:any;
  userid!: number;
username!: string;
email!: string;
fname!: string;
lname!: string;
phno!: bigint;
role!: string;
isactive!: boolean;
dob!: Date;
created_on!: Date;
pwd!: string;

data!:string;

  posData!:UserInterface;

  public users:any =[];

  constructor(private dataService:signupService,private router: Router) { }

  ngOnInit(){

    this.form=new FormGroup({
      userid:new FormControl("",Validators.compose([Validators.required])),
      username:new FormControl("",Validators.compose([Validators.required])),
      email:new FormControl("",Validators.compose([Validators.required])),
      fname:new FormControl("",Validators.compose([Validators.required])),
      lname:new FormControl("",Validators.compose([Validators.required])),
      phno:new FormControl("",Validators.compose([Validators.required])),
      role:new FormControl("",Validators.compose([Validators.required])),
      isactive:new FormControl("",Validators.compose([Validators.required])),
      dob:new FormControl("",Validators.compose([Validators.required])),
      created_on:new FormControl("",Validators.compose([Validators.required])),
      pwd:new FormControl("",Validators.compose([Validators.required]))
  });
}
onClick(){
  this.router.navigate(['/'])
}
onSubmit(user:any){

  console.log(user);
  this.posData=new UserInterface();

  this.posData.userid=user.userid;
  this.posData.username=user.username;
  this.posData.email=user.email;
  this.posData.fname=user.fname;
  this.posData.lname=user.lname;
  this.posData.phno=user.phno;
  this.posData.role=user.role;
  this.posData.isactive=user.isactive;
  this.posData.dob=user.dob;
  this.posData.created_on=user.created_on;
  this.posData.pwd=user.pwd;
  console.log(this.posData);
  this.dataService.addPost(this.posData).subscribe(
    data=>{ if(data == true)
      {
        alert("New User Created SucessFully, Go Back to Login using your credentials");
          this.router.navigate(['/']);
      }
  
      else
      {
      alert("Please enter Valid Credentials");
      }}
  )  
}
}