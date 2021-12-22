import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { taskComp } from './dynamic-apicall/taskComp';
import { loginComp } from './dynamic-apicall/loginComp';
import { signupComp } from './dynamic-apicall/signupComp';
import { addtaskComp } from './dynamic-apicall/addtask/addtaskComp';
import { AssigntaskComponent } from './dynamic-apicall/assigntask/assigntaskComp';
import { priComp } from './dynamic-apicall/priority/priComp';
import { AddNotesComponent } from './dynamic-apicall/notes/notesComp';
import { TrackTaskComponent } from './dynamic-apicall/track/trackComp';
import { searchComp } from './dynamic-apicall/search/searchComp';
import { HomeComp } from './dynamic-apicall/HomeComp';
import { csComp } from './dynamic-apicall/cs/csComp';
const routes: Routes = [{ path: 'home', component:HomeComp },
                        {path:'signup',component:signupComp},
                        {path:'',component:loginComp},
                        {path:'addtask',component:addtaskComp},
                        {path:'assigntask',component:AssigntaskComponent},
                        {path:'setpri',component:priComp},
                        {path:'notes',component:AddNotesComponent},
                        {path:'track',component:TrackTaskComponent},
                        {path:'alltask',component:taskComp},
                        {path:'search',component:searchComp},
                        {path:'cs',component:csComp}
                      ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
