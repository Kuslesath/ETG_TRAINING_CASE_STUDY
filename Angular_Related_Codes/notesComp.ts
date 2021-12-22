import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators } from "@angular/forms"; 
import { Router } from '@angular/router';
import { TaskInterface } from '../TaskInterface';
import { notesservice } from './notesService';

@Component({
  selector: 'app-add-notes',
  templateUrl: './notes.html',
  styleUrls: ['../dynamic-apicall.component.css']
})
export class AddNotesComponent implements OnInit {
 // public tasks!:TaskInterface[];
  form2!:any;
  taskid!:number;
  notes!:string;
  isbookMarked!:string;


  constructor(private ts:notesservice, private router:Router) { }

  ngOnInit(){
    this.form2=new FormGroup({
      notes:new FormControl("",Validators.compose([])),
        taskid:new FormControl("",Validators.compose([Validators.required])),
        isbookMarked:new FormControl("",Validators.compose([Validators.required]))
       
    });
}
onSubmitnotes(user1:any)  {
  console.log(user1);
this.ts.notes(user1.notes,user1.taskid).subscribe(data=> {
     if(data == true)
    {
        console.log(user1.isbookMarked);
        this.ts.bookmark(user1.isbookMarked,user1.taskid).subscribe(data=> { 
            if(data == true)
            {
              alert("Bookmark and Notes have been updated for Task no "+user1.taskid);
                this.router.navigate(['/home']);
            }
        
            else
            {
            alert("Please enter Valid BookMark Credentials");
            }})
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