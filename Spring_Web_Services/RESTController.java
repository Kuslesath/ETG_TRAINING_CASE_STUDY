package com.sonata.springMvc1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sonata.impl.DefaultTask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public Task addTask(@RequestBody Task t) throws Exception
	{
		task.addTask(t);
		return t;
	}
	
	//POST - Create a user
	@PostMapping(value= "/adduser", consumes = "application/json", produces = "application/json")
	public User addUser(@RequestBody User u) throws Exception
	{
		user.addUser(u);
		return u;
	}
	
	//GET - As a portal admin, I should be able to assign task to the team member (taskid, userid)
	@RequestMapping(value ="/assigntaskto/{userid}/taskid/{taskid}",method = RequestMethod.GET,produces = {"application/json","application/xml"})
	public List<Task> assignTask(@PathVariable int userid, @PathVariable int taskid,  Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("taskid", taskid);
		row=task.assignTask(taskid,userid);
		return task.printTask(taskid);
	}
	
	//GET - As a admin, I should be able to prioritize tasks (taskid, priority)
	@RequestMapping(value ="/setpriority/{pri}/taskid/{taskid}",method = RequestMethod.GET,produces = {"application/json","application/xml"})
	public List<Task> printTask(@PathVariable int taskid, @PathVariable String pri, Model model) {
		model.addAttribute("pri", pri);
		model.addAttribute("taskid", taskid);
		row=task.setPriority(taskid,pri);
		return task.printTask(taskid);
	}
	
	//GET - As a admin, I should be able to add internal notes (taskid, notes)
	@RequestMapping(value ="/addnotes/{notes}/taskid/{taskid}",method = RequestMethod.GET,produces = {"application/json","application/xml"})
	public List<Task> addNotes(@PathVariable int taskid, @PathVariable String notes, Model model) {
		model.addAttribute("notes", notes);
		model.addAttribute("taskid", taskid);
		row=task.addNotes(taskid,notes);
		return task.printTask(taskid);
	}
	
	//GET - As a admin, I should be able to add bookmark (taskid, bookmark)
	@RequestMapping(value ="/ibm/{ibm}/taskid/{taskid}",method = RequestMethod.GET,produces = {"application/json","application/xml"})
	public List<Task> addBookmark(@PathVariable int taskid, @PathVariable String ibm, Model model) {
			model.addAttribute("ibm", ibm);
			model.addAttribute("taskid", taskid);
			row=task.addNotes(taskid,ibm);
			return task.printTask(taskid);
		}
	
	//GET - As a admin, I should be able to searching tasks easier (taskid)
	@RequestMapping(value ="/searchtask/{taskid}",method = RequestMethod.GET,produces = {"application/json","application/xml"})
	public List<Task> searchTask(@PathVariable int taskid, Model model) {
		model.addAttribute("taskid", taskid);
		return task.printTask(taskid);
	}
	
	//GET - As a admin, I should be able to gat all tasks
	@RequestMapping(value = "/alltask", method = RequestMethod.GET,produces = {"application/json","application/xml"})
	public List<Task> getAllTask() {
		return task.getAllTask();
	}
	
	//GET -As a admin, I should be able to track completion of all tasks (status)
	@RequestMapping(value ="/status/{status}",method = RequestMethod.GET,produces = {"application/json","application/xml"})
	public List<Task> searchtask(@PathVariable String status, Model model) {
		model.addAttribute("status",status);
		return task.status(status);
	}
	
}
