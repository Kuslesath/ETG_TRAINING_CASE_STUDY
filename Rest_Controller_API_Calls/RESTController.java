package com.sonata.springMvc1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import org.springframework.ui.Model;


@CrossOrigin(origins="http://localhost:3000")

@RestController
//@org.springframework.beans.factory.annotation.Autowired(required=true)	
public class RESTController {
	
	@Autowired
	TaskInterface task;
	@Autowired
	UserInterface user;
	int row=0;
			
	//POST - As a Portal Admin, I should be able to create a task
	@PostMapping(value= "/addtask", consumes = "application/json", produces = "application/json")
	public boolean addTask(@RequestBody Task t) throws Exception
	{
		return task.addTask(t);
	}
	
	//POST - Create a user
	@PostMapping(value= "/adduser", consumes = "application/json", produces = "application/json")
	public boolean addUser(@RequestBody User u) throws Exception
	{
		return user.addUser(u);
	}
	
	//GET - As a portal admin, I should be able to assign task to the team member (taskid, userid)
	@RequestMapping(value ="/assigntaskto/{userid}/taskid/{taskid}",method = RequestMethod.GET,produces = {"application/json"})
	public boolean assignTask(@PathVariable int userid, @PathVariable int taskid,  Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("taskid", taskid);
		return task.assignTask(taskid,userid);
	}
	
	//GET - As a admin, I should be able to prioritize tasks (taskid, priority)
	@RequestMapping(value ="/setpriority/{pri}/taskid/{taskid}",method = RequestMethod.GET,produces = {"application/json"})
	public boolean printTask(@PathVariable int taskid, @PathVariable String pri, Model model) {
		model.addAttribute("pri", pri);
		model.addAttribute("taskid", taskid);
		return task.setPriority(taskid,pri);
		
	}
	
	//GET - As a admin, I should be able to add internal notes (taskid, notes)
	@RequestMapping(value ="/addnotes/{notes}/taskid/{taskid}",method = RequestMethod.GET,produces = {"application/json"})
	public boolean addNotes(@PathVariable int taskid, @PathVariable String notes, Model model) {
		model.addAttribute("notes", notes);
		model.addAttribute("taskid", taskid);
		return task.addNotes(taskid,notes);
	
	}
	
	//GET - As a admin, I should be able to add bookmark (taskid, bookmark)
	@RequestMapping(value ="/ibm/{ibm}/taskid/{taskid}",method = RequestMethod.GET,produces = {"application/json"})
	public boolean addBookmark(@PathVariable int taskid, @PathVariable String ibm, Model model) {
			model.addAttribute("ibm", ibm);
			model.addAttribute("taskid", taskid);
			return task.addBookmark(taskid,ibm);
			 
		}
	
	//GET - As a admin, I should be able to searching tasks easier (taskid)
	@RequestMapping(value ="/{key}/{value}",method = RequestMethod.GET,produces = {"application/json"})
	public List<Task> searchTask(@PathVariable String key,@PathVariable String value, Model model) {
		model.addAttribute("key",key);
		model.addAttribute("value",value);
		return task.printTask(key,value);
	}
	
	//GET - As a admin, I should be able to gat all tasks
	@RequestMapping(value = "/alltask", method = RequestMethod.GET,produces = {"application/json"})
	public List<Task> getAllTask() {
		return task.getAllTask();
	}
	@CrossOrigin(origins="http://localhost:4200")
	//GET -As a admin, I should be able to track completion of all tasks (status)
	@RequestMapping(value ="/status/{status}",method = RequestMethod.GET,produces = {"application/json"})
	public List<Task> searchtask(@PathVariable String status, Model model) {
		model.addAttribute("status",status);
		return task.status(status);
	}
	
	//logging in to user
	@RequestMapping(value ="/uname/{uname}/pwd/{pwd}",method = RequestMethod.GET,produces = {"application/json"})
	public boolean login(@PathVariable String pwd, @PathVariable String uname, Model model) throws SQLException {
			model.addAttribute("uname",uname);
			model.addAttribute("pwd", pwd);
			return user.login(uname, pwd);
		}
	//GET - As a admin, I should be able to gat all tasks
		@RequestMapping(value = "/allusers", method = RequestMethod.GET,produces = {"application/json"})
		public List<User> getAllUsers() {
			return user.getAllUsers();
		}
		
		@RequestMapping(value ="/taskid/{taskid}/status/{status}/date/{status_changed_on}",method = RequestMethod.GET,produces = {"application/json"})
		public boolean changestatus(@PathVariable int taskid, @PathVariable String status,@PathVariable String status_changed_on ,Model model) {
			model.addAttribute("taskid", taskid);
			model.addAttribute("status",status);
			model.addAttribute("status_changed_on",status_changed_on);
			return task.changestatus(taskid,status,status_changed_on);
			
		}
		//GET - As a admin, I should be able to searching tasks easier (taskid)
		@RequestMapping(value ="/taskdel/{value}",method = RequestMethod.GET,produces = {"application/json"})
		public boolean taskdel(@PathVariable int value, Model model) {
			model.addAttribute("value",value);
			return task.taskdel(value);
		}
}
