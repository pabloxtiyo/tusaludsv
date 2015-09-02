/**
 * 
 */
package com.tusaludsv.model.entity;

import java.io.Serializable;

/**
 * @Autor Pablo.Portillo
 * @FechaCreacion 06/07/2015.10:35:48
 * @Empresa Grupo.GD
 */
public class TmTask implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer pkTmTsk;
	/**
	 * Esta variable define si esta tarea
	 * depende o no de otra tarea y si esta
	 * ya ha terminado.
	 */
	private String dependTask;
	private String tskTeam;
	private String tskPriority;
	private String tskProject;
	private String tskStatus;
	private String tskOwner;
	private String tskDescription;
	private String systemOperation;
	private String tskEstimatedStartTime;
	private String tskEstimatedEndTime;
	private int tskEstimatedTotalTime;
	private String tskRealStartTime;
	private String tskRealEndTime;
	private int tskRealTotalTime;
	private int tskEstimatedPercent;
	private int tskRealPercent;
	private int tskIdDepend;
	
	
	
	
	
	public TmTask() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param pkTmTsk
	 * @param dependTask
	 * @param tskTeam
	 * @param tskPriority
	 * @param tskProject
	 * @param tskStatus
	 * @param tskOwner
	 * @param tskDescription
	 * @param systemOperation
	 * @param tskEstimatedStartTime
	 * @param tskEstimatedEndTime
	 * @param tskEstimatedTotalTime
	 * @param tskRealStartTime
	 * @param tskRealEndTime
	 * @param tskRealTotalTime
	 * @param tskEstimatedPercent
	 * @param tskRealPercent
	 */
	public TmTask(Integer pkTmTsk, String dependTask, String tskTeam,
			String tskPriority, String tskProject, String tskStatus,
			String tskOwner, String tskDescription, String systemOperation,
			String tskEstimatedStartTime, String tskEstimatedEndTime,
			int tskEstimatedTotalTime, String tskRealStartTime,
			String tskRealEndTime, int tskRealTotalTime, int tskEstimatedPercent,
			int tskRealPercent) {
		super();
		this.pkTmTsk = pkTmTsk;
		this.dependTask = dependTask;
		this.tskTeam = tskTeam;
		this.tskPriority = tskPriority;
		this.tskProject = tskProject;
		this.tskStatus = tskStatus;
		this.tskOwner = tskOwner;
		this.tskDescription = tskDescription;
		this.systemOperation = systemOperation;
		this.tskEstimatedStartTime = tskEstimatedStartTime;
		this.tskEstimatedEndTime = tskEstimatedEndTime;
		this.tskEstimatedTotalTime = tskEstimatedTotalTime;
		this.tskRealStartTime = tskRealStartTime;
		this.tskRealEndTime = tskRealEndTime;
		this.tskRealTotalTime = tskRealTotalTime;
		this.tskEstimatedPercent = tskEstimatedPercent;
		this.tskRealPercent = tskRealPercent;
	}
	/**
	 * @return the pkTmTsk
	 */
	public Integer getPkTmTsk() {
		return pkTmTsk;
	}
	/**
	 * @param pkTmTsk the pkTmTsk to set
	 */
	public void setPkTmTsk(Integer pkTmTsk) {
		this.pkTmTsk = pkTmTsk;
	}
	/**
	 * @return the dependTask
	 */
	public String isDependTask() {
		return dependTask;
	}
	/**
	 * @param dependTask the dependTask to set
	 */
	public void setDependTask(String dependTask) {
		this.dependTask = dependTask;
	}
	/**
	 * @return the tskTeam
	 */
	public String getTskTeam() {
		return tskTeam;
	}
	/**
	 * @param tskTeam the tskTeam to set
	 */
	public void setTskTeam(String tskTeam) {
		this.tskTeam = tskTeam;
	}
	/**
	 * @return the tskPriority
	 */
	public String getTskPriority() {
		return tskPriority;
	}
	/**
	 * @param tskPriority the tskPriority to set
	 */
	public void setTskPriority(String tskPriority) {
		this.tskPriority = tskPriority;
	}
	/**
	 * @return the tskProject
	 */
	public String getTskProject() {
		return tskProject;
	}
	/**
	 * @param tskProject the tskProject to set
	 */
	public void setTskProject(String tskProject) {
		this.tskProject = tskProject;
	}
	/**
	 * @return the tskStatus
	 */
	public String getTskStatus() {
		return tskStatus;
	}
	/**
	 * @param tskStatus the tskStatus to set
	 */
	public void setTskStatus(String tskStatus) {
		this.tskStatus = tskStatus;
	}
	/**
	 * @return the tskOwner
	 */
	public String getTskOwner() {
		return tskOwner;
	}
	/**
	 * @param tskOwner the tskOwner to set
	 */
	public void setTskOwner(String tskOwner) {
		this.tskOwner = tskOwner;
	}
	/**
	 * @return the tskDescription
	 */
	public String getTskDescription() {
		return tskDescription;
	}
	/**
	 * @param tskDescription the tskDescription to set
	 */
	public void setTskDescription(String tskDescription) {
		this.tskDescription = tskDescription;
	}
	/**
	 * @return the systemOperation
	 */
	public String getSystemOperation() {
		return systemOperation;
	}
	/**
	 * @param systemOperation the systemOperation to set
	 */
	public void setSystemOperation(String systemOperation) {
		this.systemOperation = systemOperation;
	}
	/**
	 * @return the tskEstimatedStartTime
	 */
	public String getTskEstimatedStartTime() {
		return tskEstimatedStartTime;
	}
	/**
	 * @param tskEstimatedStartTime the tskEstimatedStartTime to set
	 */
	public void setTskEstimatedStartTime(String tskEstimatedStartTime) {
		this.tskEstimatedStartTime = tskEstimatedStartTime;
	}
	/**
	 * @return the tskEstimatedEndTime
	 */
	public String getTskEstimatedEndTime() {
		return tskEstimatedEndTime;
	}
	/**
	 * @param tskEstimatedEndTime the tskEstimatedEndTime to set
	 */
	public void setTskEstimatedEndTime(String tskEstimatedEndTime) {
		this.tskEstimatedEndTime = tskEstimatedEndTime;
	}
	/**
	 * @return the tskEstimatedTotalTime
	 */
	public int getTskEstimatedTotalTime() {
		return tskEstimatedTotalTime;
	}
	/**
	 * @param tskEstimatedTotalTime the tskEstimatedTotalTime to set
	 */
	public void setTskEstimatedTotalTime(int tskEstimatedTotalTime) {
		this.tskEstimatedTotalTime = tskEstimatedTotalTime;
	}
	/**
	 * @return the tskRealStartTime
	 */
	public String getTskRealStartTime() {
		return tskRealStartTime;
	}
	/**
	 * @param tskRealStartTime the tskRealStartTime to set
	 */
	public void setTskRealStartTime(String tskRealStartTime) {
		this.tskRealStartTime = tskRealStartTime;
	}
	/**
	 * @return the tskRealEndTime
	 */
	public String getTskRealEndTime() {
		return tskRealEndTime;
	}
	/**
	 * @param tskRealEndTime the tskRealEndTime to set
	 */
	public void setTskRealEndTime(String tskRealEndTime) {
		this.tskRealEndTime = tskRealEndTime;
	}
	/**
	 * @return the tskRealTotalTime
	 */
	public int getTskRealTotalTime() {
		return tskRealTotalTime;
	}
	/**
	 * @param tskRealTotalTime the tskRealTotalTime to set
	 */
	public void setTskRealTotalTime(int tskRealTotalTime) {
		this.tskRealTotalTime = tskRealTotalTime;
	}
	/**
	 * @return the tskEstimatedPercent
	 */
	public int getTskEstimatedPercent() {
		return tskEstimatedPercent;
	}
	/**
	 * @param tskEstimatedPercent the tskEstimatedPercent to set
	 */
	public void setTskEstimatedPercent(int tskEstimatedPercent) {
		this.tskEstimatedPercent = tskEstimatedPercent;
	}
	/**
	 * @return the tskRealPercent
	 */
	public int getTskRealPercent() {
		return tskRealPercent;
	}
	/**
	 * @param tskRealPercent the tskRealPercent to set
	 */
	public void setTskRealPercent(int tskRealPercent) {
		this.tskRealPercent = tskRealPercent;
	}
	
	public int getTskIdDepend() {
		return tskIdDepend;
	}
	public void setTskIdDepend(int tskIdDepend) {
		this.tskIdDepend = tskIdDepend;
	}
	
	
	/**
	 * @return the dependTask
	 */
	public String getDependTask() {
		return dependTask;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TmTask [pkTmTsk=" + pkTmTsk + ", dependTask=" + dependTask
				+ ", tskTeam=" + tskTeam + ", tskPriority=" + tskPriority
				+ ", tskProject=" + tskProject + ", tskStatus=" + tskStatus
				+ ", tskOwner=" + tskOwner + ", tskDescription="
				+ tskDescription + ", systemOperation=" + systemOperation
				+ ", tskEstimatedStartTime=" + tskEstimatedStartTime
				+ ", tskEstimatedEndTime=" + tskEstimatedEndTime
				+ ", tskEstimatedTotalTime=" + tskEstimatedTotalTime
				+ ", tskRealStartTime=" + tskRealStartTime
				+ ", tskRealEndTime=" + tskRealEndTime + ", tskRealTotalTime="
				+ tskRealTotalTime + ", tskEstimatedPercent="
				+ tskEstimatedPercent + ", tskRealPercent=" + tskRealPercent
				+ ", tskIdDepend=" + tskIdDepend + "]";
	}
	
	

	
}
