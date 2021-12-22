import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MyCom } from './MyCom';
import { MyCom1 } from './MyCom1';
import { ifelse } from './if-else';
import { customDirectory } from './customDirectory';
import { product } from './product';
import { PipeExampleComponent } from './pipe-example/pipe-example.component';
import { SortPipe } from './pipe-example/customSort';
import { FormExample } from './form';
import { ReactiveFormExample } from './rform';
import { ReactiveFormsModule } from '@angular/forms';
import { Taskform } from './task';
import { SerComp } from './SerComp';
import {HttpClientModule} from '@angular/common/http';
import { EmployeeDetailsComponents } from './ecomp';
import { DynamicAPICallComponent } from './dynamic-apicall/dynamic-apicall.component';
import { taskComp } from './dynamic-apicall/taskComp';
import { MyModule } from './MyModule';
import { loginComp } from './dynamic-apicall/loginComp';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSliderModule} from '@angular/material/slider';
import {MatToolbarModule} from '@angular/material/toolbar';
import { signupComp } from './dynamic-apicall/signupComp';
import { addtaskComp } from './dynamic-apicall/addtask/addtaskComp';
import { AssigntaskComponent } from './dynamic-apicall/assigntask/assigntaskComp';
import { priComp } from './dynamic-apicall/priority/priComp';
import { AddNotesComponent } from './dynamic-apicall/notes/notesComp';
import { TrackTaskComponent } from './dynamic-apicall/track/trackComp';
import { searchComp } from './dynamic-apicall/search/searchComp';
import { HomeComp } from './dynamic-apicall/HomeComp';
import { BackButtonDisableModule } from 'angular-disable-browser-back-button';
import { csComp } from './dynamic-apicall/cs/csComp';
@NgModule({
  declarations: [
    AppComponent,MyCom1,searchComp,csComp,HomeComp,loginComp,MyCom,TrackTaskComponent,addtaskComp,AddNotesComponent,signupComp,taskComp,ifelse,customDirectory,product,AssigntaskComponent,priComp, PipeExampleComponent, SortPipe,FormExample,ReactiveFormExample,Taskform,SerComp,EmployeeDetailsComponents, DynamicAPICallComponent
  ],
  imports: [
    BrowserModule,FormsModule,MyModule,
    AppRoutingModule,ReactiveFormsModule,HttpClientModule, BrowserAnimationsModule,MatSliderModule,MatToolbarModule,
    BackButtonDisableModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
