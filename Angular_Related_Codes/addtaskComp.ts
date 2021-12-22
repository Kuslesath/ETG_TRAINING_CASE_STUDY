
import { Component,OnInit } from "@angular/core";
import { FormGroup,FormControl,Validators } from "@angular/forms"; 
import { Router } from "@angular/router";
import { TaskInterface } from '../TaskInterface';
import { UserInterface } from "../UserInterface";
import { addtaskService } from "./addtaskService";
import { getuserService } from "./getuserService";
@Component({
    selector:"posteg",
    templateUrl:'./addtask.html',
    styleUrls: ['../dynamic-apicall.component.css']})

export class addtaskComp implements OnInit{
  
  form:any;
  taskid!:number;
  ownerid!:number;
  creatorid!:number;
  name!:string;
  descrptn!:string;
  status!:string;
  priority!:string;
  notes1!:string;
  isbookmarked!:string;
  created_on!:Date;
  status_changed_on!:Date;

  data!:string;

  posData!:TaskInterface;

  public users!:UserInterface[];
  constructor(private dataService:addtaskService,private router: Router,private us:getuserService) { }

  ngOnInit(){

    this.us.getTasks().subscribe(data=>this.users=data);


    this.form=new FormGroup({
      taskid:new FormControl("",Validators.compose([Validators.required])),
      ownerid:new FormControl("",Validators.compose([Validators.required])),
      creatorid:new FormControl("",Validators.compose([Validators.required])),
      name:new FormControl("",Validators.compose([Validators.required])),
      descrptn:new FormControl("",Validators.compose([Validators.required])),
      status:new FormControl("",Validators.compose([Validators.required])),
      priority:new FormControl("",Validators.compose([Validators.required])),
      notes1:new FormControl("",Validators.compose([Validators.required])),
      isbookMarked:new FormControl("",Validators.compose([Validators.required])),
      created_on:new FormControl("",Validators.compose([Validators.required])),
      status_changed_on:new FormControl("",Validators.compose([Validators.required]))
  });
}

  onSubmit(user:any){

    console.log(user);
    this.posData=new TaskInterface();

    this.posData.taskid=user.taskid;
    this.posData.ownerid=user.ownerid;
    this.posData.creatorid=user.creatorid;
    this.posData.name=user.name;
    this.posData.descrptn=user.descrptn;
    this.posData.status=user.status;
    this.posData.priority=user.priority;
    this.posData.notes="";
    this.posData.isbookMarked="";
    this.posData.created_on=user.created_on;
    this.posData.status_changed_on=user.status_changed_on;

    console.log(this.posData);
    this.dataService.addPost(this.posData).subscribe(
      data=>{ if(data == true)
        {
          alert("New User Created SucessFully, Go Back to Login using your credentials");
            this.router.navigate(['/addtask']);
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