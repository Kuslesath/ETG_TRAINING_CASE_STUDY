package com.sonata.taskModel;

public class Task {
	private int taskid;
	private int ownerid;
	private int creatorid;
	private String name;
	private String descrptn;
	private String status;
	private String priority;
	private String notes;
	private boolean isBookMarked;
	private String created_on;
	private String status_changed_on;
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public int getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(int creatorid) {
		this.creatorid = creatorid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrptn() {
		return descrptn;
	}
	public void setDescrptn(String descrptn) {
		this.descrptn = descrptn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public boolean isBookMarked() {
		return isBookMarked;
	}
	public void setBookMarked(boolean isBookMarked) {
		this.isBookMarked = isBookMarked;
	}
	public String getCreated_on() {
		return created_on;
	}
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	public String getStatus_changed_on() {
		return status_changed_on;
	}
	public void setStatus_changed_on(String status_changed_on) {
		this.status_changed_on = status_changed_on;
	}
	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", ownerid=" + ownerid + ", creatorid=" + creatorid + ", name=" + name
				+ ", descrptn=" + descrptn + ", status=" + status + ", priority=" + priority + ", notes=" + notes
				+ ", isBookMarked=" + isBookMarked + ", created_on=" + created_on + ", status_changed_on="
				+ status_changed_on + "]";
	}
}
