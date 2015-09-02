package com.tusaludsv.model.entity;

import java.io.Serializable;

public class TmTaskStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String pkTmTaskStatus;
	private String taskStatusDescription;
	
	
	
	public TmTaskStatus() {
		super();
	}
	
	public TmTaskStatus(String pkTmTaskStatus, String taskStatusDescription) {
		super();
		this.pkTmTaskStatus = pkTmTaskStatus;
		this.taskStatusDescription = taskStatusDescription;
	}
	
	public String getPkTmTaskStatus() {
		return pkTmTaskStatus;
	}
	public void setPkTmTaskStatus(String pkTmTaskStatus) {
		this.pkTmTaskStatus = pkTmTaskStatus;
	}
	public String getTaskStatusDescription() {
		return taskStatusDescription;
	}
	public void setTaskStatusDescription(String taskStatusDescription) {
		this.taskStatusDescription = taskStatusDescription;
	}

	@Override
	public String toString() {
		return "TmTaskStatus [pkTmTaskStatus=" + pkTmTaskStatus
				+ ", taskStatusDescription=" + taskStatusDescription + "]";
	}
	
}
