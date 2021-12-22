import axios from "axios";

import React, { Component } from "react";



class ApiDel extends Component {

    constructor(props){

        super(props)

        this.state = {

            taskid:''


        }

        this.changeHandler=this.changeHandler.bind(this);

        this.submitHandler=this.submitHandler.bind(this);

    }



    changeHandler = (event) => {

        this.setState({[event.target.name]:event.target.value})

    }
    submitHandler = (event) => {

        event.preventDefault()

        console.log(this.state)

        axios.get("http://localhost:8080/taskdel/"+this.state.taskid,this.state)

        .then(response => {

            console.log(response)

        })
        
        .catch(error => {

            console.log(error)

        })

    }
    render(){

        const {taskid} = this.state

        return (

           

                        <form  onSubmit={this.submitHandler}>
                            <br></br>
                            <div>
                                Enter Task ID to delete :    . 
                                <input type="number" name="taskid" value={taskid} onChange={this.changeHandler} placeholder="Task ID" required/>

                            </div>

                           

                           <br></br>
                            <button type="submit">Submit</button>

                        </form>

               

        )

    }

}

export default ApiDel;