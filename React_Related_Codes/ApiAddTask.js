import React, { Component } from "react";

import axios from "axios";

class ApiAddTask extends Component{

    constructor(props){

        super(props)

        this.state={

            taskid:'',

            ownerid:'',

            creatorid:'',

            name:'',

            descrptn:'',

            status:'',

            priority:'',

            notes:'',

            isbookmarked:'',

            created_on:'',

            status_changed_on:''



        }

        this.changeHandler=this.changeHandler.bind(this);

        this.submitHandler=this.submitHandler.bind(this);

    }
    changeHandler(e){

        this.setState({[e.target.name]:e.target.value})

    }

    submitHandler(e){

        e.preventDefault()

        console.log(this.state)

        axios.post('http://localhost:8080/addtask',this.state)

        .then(response =>{

            console.log(response)

        })

        .catch(error=>{

            console.log(error)

        })

    }
    render(){

        const{taskid, ownerid,creatorid,name,descrptn,status,priority,notes,isbookmarked,created_on,status_changed_on} = this.state

        return(

            <div>
                <br></br>
                <form onSubmit={this.submitHandler}>

                    <div>

                        TASKID  :

                        <input type="text" name="taskid" value={taskid} onChange={this.changeHandler}/>

                    </div>
                    <br></br>

                    <div>

                        OWNERID  :

                        <input type="text" name="ownerid" value={ownerid} onChange={this.changeHandler}/>

                    </div>
                    <br></br>
                      <div>

                        CREATORID  :

                        <input type="text" name="creatorid" value={creatorid} onChange={this.changeHandler}/>

                    </div>

                    <br></br>
                    <div>

                        NAME :

                        <input type="text" name="name" value={name} onChange={this.changeHandler}/>

                    </div>
                    <br></br>
                     <div>

                        Description :

                        <input type="text" name="descrptn" value={descrptn} onChange={this.changeHandler}/>

                    </div>
                    <br></br>
                     <div>

                        STATUS :

                        <input type="text" name="status" value={status} onChange={this.changeHandler}/>

                    </div>
                    <br></br>
                     <div>

                        PRIORITY :
                        <input type="text" name="priority" value={priority} onChange={this.changeHandler}/>



                    </div>
                    <br></br>
                    <div>

                        NOTES:
                    <input type="text" name="notes" value={notes} onChange={this.changeHandler}/>

                    </div>
                    <br></br>
                     <div>

                        ISBOOKMARKED :
                        <input type="text" name="isbookmarked" value={isbookmarked} onChange={this.changeHandler}/>



                    </div>

                    <br></br>


                <div>

                        CREATED ON :

                        <input type="date" name="created_on" value={created_on} onChange={this.changeHandler}/>

                    </div>
                    <br></br>
                    <div>



                         STATUS CHANGED ON :



                        <input type="date" name="status_changed_on" value={status_changed_on} onChange={this.changeHandler}/>



                    </div>
                    <br></br>




                    

           

                    <button type="submit">Submit</button>

                </form>

            </div>

        )

    }

}

export default ApiAddTask;