package com.sonata.notificationModel;

public class Notification {

	private int nid;
	private int taskid;
	private int taskownerid;
	private String status;
	private String created_on;
	private String status_changed_on;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public int getTaskownerid() {
		return taskownerid;
	}
	public void setTaskownerid(int taskownerid) {
		this.taskownerid = taskownerid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		return "Notification [nid=" + nid + ", taskid=" + taskid + ", taskownerid=" + taskownerid + ", status=" + status
				+ ", created_on=" + created_on + ", status_changed_on=" + status_changed_on + "]";
	}
}
