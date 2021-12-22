import React from "react";
import axios from "axios";
import StudComponent from "./StudComponent";
import ClassComponent from "./ClassComponent";
import AssignmentProdComp from "./AssignmentProdComp";
import StateExample from "./StateExample";
import reactDom from "react-dom";
import { Route, Link, BrowserRouter as Router, Routes } from "react-router-dom";
import ApiSearch from "./CRUD-operations/ApiSearch";
import ApiGet from "./CRUD-operations/ApiGet";
import ApiAddTask from "./CRUD-operations/ApiAddTask";
import ApiUpdate from "./CRUD-operations/ApiUpdate";
import ApiDel from "./CRUD-operations/ApiDel";


const routing =(
    <Router>
        <center>
        <div>
            <ul>
            <h3>
                <Link to="/add" > Add Task </Link>

                </h3>
                <h3> <Link to="/search" > Retrive Task </Link></h3>
               <h3> <Link to="/getalltasks" > Get All Tasks</Link></h3>
                <h3><Link to="/update" > Update Priority</Link></h3>
                <h3><Link to="/del" > Delete Task</Link></h3>
                

            </ul>
        <Routes>
        <Route path="/add" element ={<ApiAddTask />} />
            <Route path="/search" element ={<ApiSearch />} />
            <Route path="/getalltasks" element ={<ApiGet />} />
            <Route path="/update" element ={<ApiUpdate />} />
            <Route path="/del" element ={<ApiDel />} />
        </Routes>
        </div>
        </center>
    </Router>
)
export default  routing;