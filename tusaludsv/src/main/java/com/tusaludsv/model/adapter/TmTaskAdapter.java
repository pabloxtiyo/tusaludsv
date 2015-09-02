package com.tusaludsv.model.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tusaludsv.model.entity.TmTask;

/**
 * @Autor Pablo.Portillo
 * @FechaCreacion 06/07/2015.11:13:45
 * @Empresa Grupo.GD
 */
public class TmTaskAdapter 
{

	public List<TmTask> getListByDate(ResultSet rs)
	{
		List<TmTask> list = new ArrayList<TmTask>();
		
		try 
		{
			rs.beforeFirst();
			while(rs.next())
			{
				TmTask tsk = new TmTask();
				tsk.setPkTmTsk(rs.getInt("PK_TM_TASK"));
				tsk.setTskEstimatedStartTime(rs.getString("ESTIMATED_START_TIME"));
				tsk.setTskEstimatedEndTime(rs.getString("ESTIMATED_END_TIME"));
				tsk.setTskEstimatedPercent(rs.getInt("ESTIMATED_PERCENT_PROGRESS"));
				list.add(tsk);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<TmTask> getList(ResultSet rs)
	{
		List<TmTask> list = new ArrayList<TmTask>();
		
		try 
		{
			rs.beforeFirst();
			while(rs.next())
			{
				list.add(new TmTask(
						rs.getInt("PK_TM_TASK"),
						rs.getString("tsk_depended"),
						rs.getString("tsk_team"),
						rs.getString("tsk_priority"),
						rs.getString("tsk_project"),
						rs.getString("tsk_status"),
						rs.getString("tsk_owner"),
						rs.getString("tsk_description"),
						rs.getString("system_operation"),
						rs.getString("ESTIMATED_START_TIME"),
						rs.getString("ESTIMATED_END_TIME"),
						rs.getInt("ESTIMATED_TOTAL_TIME"),
						rs.getString("REAL_START_TIME"),
						rs.getString("REAL_END_TIME"),
						rs.getInt("REAL_TOTAL_TIME"),
						rs.getInt("ESTIMATED_PERCENT_PROGRESS"),
						rs.getInt("REAL_PERCENT_PROGRESS")));
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<TmTask> getTaskMangerList(ResultSet rs)
	{
		List<TmTask> list = new ArrayList<TmTask>();
		
		try 
		{
			rs.beforeFirst();
			while(rs.next())
			{
				TmTask tmTask = new TmTask();
				tmTask.setPkTmTsk(rs.getInt("PK_TM_TASK"));
				tmTask.setTskDescription(rs.getString("TASK_DESCRIPTION"));
				tmTask.setSystemOperation(rs.getString("SYSTEM_OPERATION"));
				tmTask.setTskIdDepend(rs.getInt("FK_TM_TASK_DEPEND"));
				tmTask.setTskPriority(rs.getString("TASK_PRIORITY_DESCRIPTION"));
				tmTask.setTskOwner(rs.getString("TASK_OWNER_USERNAME"));
				tmTask.setTskProject(rs.getString("PROJECT_NAME"));
				tmTask.setTskTeam(rs.getString("TEAM_NAME"));
				tmTask.setTskStatus(rs.getString("TASK_STATUS_DESCRIPTION"));
				tmTask.setTskEstimatedStartTime(rs.getString("ESTIMATED_START_TIME"));
				tmTask.setTskEstimatedEndTime(rs.getString("ESTIMATED_END_TIME"));
				tmTask.setTskEstimatedTotalTime(rs.getInt("ESTIMATED_TOTAL_TIME"));
				tmTask.setTskEstimatedPercent(rs.getInt("ESTIMATED_PERCENT_PROGRESS"));
				tmTask.setTskRealStartTime(rs.getString("REAL_START_TIME"));
				tmTask.setTskRealEndTime(rs.getString("REAL_END_TIME"));
				tmTask.setTskRealTotalTime(rs.getInt("REAL_TOTAL_TIME"));
				tmTask.setTskRealPercent(rs.getInt("REAL_PERCENT_PROGRESS"));
				
				list.add(tmTask);
				
				tmTask = null;
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
	
}
