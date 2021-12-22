import React, { Component } from "react";
import axios from "axios";

class ApiGet extends Component{
    constructor(props){
        super(props)
        this.state = {
            
            tasks:[]
        }
        this.handleClick= this.handleClick.bind(this)
    }
        handleClick () {
            axios.get('http://localhost:8080/alltask')
            .then(response=>{ this.setState({tasks: response.data})
            console.log(response.data)
            })
        }

        render(){
            const {tasks}= this.state
            return(
                
                <div>
                    <br></br>
                    <h3> Click here to get Details of all task </h3><button className='button' onClick={this.handleClick}> Task Details</button>
                   
                    {
                        tasks.map(task=>
                           <div key={task.taskid}> <br />
                               TASKID: {task.taskid} <br />
                               OWNERID: {task.ownerid} <br/>
                               CREATORID: {task.creatorid} <br />
                               NAME: {task.name} <br />
                               DESCRIPTION: {task.descrptn} <br />
                               STATUS: {task.status} <br />
                               PRIORITY: {task.priority} <br />
                               NOTES: {task.notes} <br />
                               CREATED_ON: {task.created_on} <br />
                               STATUS_CHANGED_ON: {task.status_changed_on} <br />
                               </div>
                            )
                    }
                    

                    </div>


            )
        }
    }
export default ApiGet;