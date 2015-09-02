package com.tusaludsv.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tusaludsv.model.adapter.TmTaskAdapter;
import com.tusaludsv.model.dao.dbaccess.QuerySQLHandler;
import com.tusaludsv.model.dao.dbaccess.SQLConnection;
import com.tusaludsv.model.dao.dbaccess.UpdateSQLHandler;
import com.tusaludsv.model.entity.TmTask;

/**
 * @Autor Pablo.Portillo
 * @FechaCreacion 06/07/2015.10:54:51
 * @Empresa Grupo.GD
 */

@Component
public class TmTaskDao implements GenericDao<TmTask> 
{

	@Override
	public TmTask insert(TmTask entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TmTask update(TmTask entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(TmTask entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TmTask> findAll() throws SQLException {
		// TODO Auto-generated method stub
		
Connection cn = new SQLConnection().getInstance();
		
		List<TmTask> list = new TmTaskAdapter().getTaskMangerList(new QuerySQLHandler(GenericSql.queryTasKManger,cn).getResultSet());
		
		cn.close();
		return list;
	}

	@Override
	public TmTask findById(int id) 
	{
		// TODO Auto-generated method stub

		String query = "SELECT tmtask.PK_TM_TASK,"
				+"Case when tmtask.FK_TM_TASK_DEPEND IS NOT NULL THEN (SELECT "
    			+" case"
    			+" when tmstss.TASK_STATUS_DESCRIPTION = 'End with Delay' AND tmt.REAL_PERCENT_PROGRESS = 100  THEN 'false'"
    			+" when tmstss.TASK_STATUS_DESCRIPTION = 'End On time' AND tmt.REAL_PERCENT_PROGRESS = 100 THEN 'false'"
    			+" else 'true'"
    			+" end"
    			+" FROM TM_TASK tmt JOIN TM_TASK_STATUS tmstss"
    			+" ON tmstss.PK_TM_TASK_STATUS   = tmt.FK_TM_TASK_STATUS" 
    			+" where tmt.PK_TM_TASK = tmtask.FK_TM_TASK_DEPEND)"
				+" else 'false'"
				+" end tsk_depended,"
					+"tmteam.TEAM_NAME as tsk_team,"
					+"tmpri.TASK_PRIORITY_DESCRIPTION as tsk_priority,"
					+"tmpro.PROJECT_NAME as tsk_project,"
					+"tmsts.TASK_STATUS_DESCRIPTION as tsk_status,"
					+"tmown.TASK_OWNER_USERNAME as tsk_owner,"
					+"tmtask.TASK_DESCRIPTION as tsk_description,"
					+"tmtask.SYSTEM_OPERATION,"
					+"tmtask.ESTIMATED_START_TIME,"
					+"tmtask.ESTIMATED_END_TIME,"
					+"tmtask.REAL_START_TIME,"
					+"tmtask.REAL_END_TIME,"
					+"tmtask.ESTIMATED_TOTAL_TIME,"
					+"tmtask.REAL_TOTAL_TIME,"
					+"tmtask.ESTIMATED_PERCENT_PROGRESS,"
					+"tmtask.REAL_PERCENT_PROGRESS"
					+" FROM TM_TASK tmtask"
					+" JOIN TM_TEAM tmteam ON tmteam.PK_TM_TEAM = tmtask.FK_TM_TEAM"
					+" JOIN TM_TASK_PRIORITY tmpri ON tmpri.PK_TM_TASK_PRIORITY   = tmtask.FK_TM_TASK_PRIORITY"
					+" JOIN TM_PROJECT tmpro ON tmpro.PK_TM_PROJECT   = tmtask.FK_TM_PROJECT"
					+" JOIN TM_TASK_STATUS tmsts ON tmsts.PK_TM_TASK_STATUS   = tmtask.FK_TM_TASK_STATUS"
					+" JOIN TM_TASK_OWNER tmown ON tmown.PK_TM_TASK_OWNER   = tmtask.FK_TM_TASK_OWNER"
					+" WHERE tmtask.PK_TM_TASK = "+id;

		
		Connection cn = new SQLConnection().getInstance();
		List<TmTask> list = new TmTaskAdapter().getList(new QuerySQLHandler(query,cn).getResultSet());
		if(!list.isEmpty())
		{
			return list.get(0);
		}
		else
		{
			return null;
		}			
	}
	
	public List<TmTask> findAllByOwner (String owner) throws SQLException
	{
		String query = "SELECT tmtask.PK_TM_TASK,"
				+"Case when tmtask.FK_TM_TASK_DEPEND IS NOT NULL THEN (SELECT "
    			+" case"
    			+" when tmstss.TASK_STATUS_DESCRIPTION = 'End with Delay' AND tmt.REAL_PERCENT_PROGRESS = 100  THEN 'false'"
    			+" when tmstss.TASK_STATUS_DESCRIPTION = 'End On time' AND tmt.REAL_PERCENT_PROGRESS = 100 THEN 'false'"
    			+" else 'true'"
    			+" end"
    			+" FROM TM_TASK tmt JOIN TM_TASK_STATUS tmstss"
    			+" ON tmstss.PK_TM_TASK_STATUS   = tmt.FK_TM_TASK_STATUS" 
    			+" where tmt.PK_TM_TASK = tmtask.FK_TM_TASK_DEPEND)"
				+" else 'false'"
				+" end tsk_depended,"
					+"tmteam.TEAM_NAME as tsk_team,"
					+"tmpri.TASK_PRIORITY_DESCRIPTION as tsk_priority,"
					+"tmpro.PROJECT_NAME as tsk_project,"
					+"tmsts.TASK_STATUS_DESCRIPTION as tsk_status,"
					+"tmown.TASK_OWNER_USERNAME as tsk_owner,"
					+"tmtask.TASK_DESCRIPTION as tsk_description,"
					+"tmtask.SYSTEM_OPERATION,"
					+"tmtask.ESTIMATED_START_TIME,"
					+"tmtask.ESTIMATED_END_TIME,"
					+"tmtask.REAL_START_TIME,"
					+"tmtask.REAL_END_TIME,"
					+"tmtask.ESTIMATED_TOTAL_TIME,"
					+"tmtask.REAL_TOTAL_TIME,"
					+"tmtask.ESTIMATED_PERCENT_PROGRESS,"
					+"tmtask.REAL_PERCENT_PROGRESS"
					+" FROM TM_TASK tmtask"
					+" JOIN TM_TEAM tmteam ON tmteam.PK_TM_TEAM = tmtask.FK_TM_TEAM"
					+" JOIN TM_TASK_PRIORITY tmpri ON tmpri.PK_TM_TASK_PRIORITY   = tmtask.FK_TM_TASK_PRIORITY"
					+" JOIN TM_PROJECT tmpro ON tmpro.PK_TM_PROJECT   = tmtask.FK_TM_PROJECT"
					+" JOIN TM_TASK_STATUS tmsts ON tmsts.PK_TM_TASK_STATUS   = tmtask.FK_TM_TASK_STATUS"
					+" JOIN TM_TASK_OWNER tmown ON tmown.PK_TM_TASK_OWNER   = tmtask.FK_TM_TASK_OWNER"
					+" WHERE tmown.TASK_OWNER_USERNAME = '"+owner+"'"
					+ " ORDER BY tmtask.REAL_PERCENT_PROGRESS DESC";	 
		
		Connection cn = new SQLConnection().getInstance();
		List<TmTask> list = new TmTaskAdapter().getList(new QuerySQLHandler(query,cn).getResultSet());
		cn.close();
		
		return list;
		
	}
	
	public List<TmTask> findAllByDate (String serverDate) throws SQLException
	{
		String query = "SELECT tmtsk.PK_TM_TASK,"
					+" TO_CHAR (tmtsk.ESTIMATED_START_TIME, 'YYYY-MM-DD HH24:MI:SS') as ESTIMATED_START_TIME,"
					+" TO_CHAR (tmtsk.ESTIMATED_END_TIME, 'YYYY-MM-DD HH24:MI:SS') as ESTIMATED_END_TIME,"
					+" tmtsk.ESTIMATED_PERCENT_PROGRESS"
					+" from TM_TASK tmtsk"
					+" WHERE tmtsk.ESTIMATED_START_TIME < to_date('"+serverDate+"', 'yyyy/mm/dd hh24:mi:ss')";
		
		Connection cn = new SQLConnection().getInstance();
		List<TmTask> list = new TmTaskAdapter().getListByDate(new QuerySQLHandler(query,cn).getResultSet());
		cn.close();
		
		return list;
		
	}
	
	public void updateEstimatedProgress(int progress,int id) throws SQLException
	{
		String query = "UPDATE TM_TASK tmtask"
				 +" SET tmtask.ESTIMATED_PERCENT_PROGRESS = "+progress
				 +" WHERE tmtask.PK_TM_TASK = "+id;
		
		Connection cn = new SQLConnection().getInstance();
		new UpdateSQLHandler(query, cn).executeQuery();
		cn.close();
	}
	
	public void updateProgress(int state,int progress,int id) throws SQLException 
	{
		// TODO Auto-generated method stub
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String endDate="";
		String startDate="";
		
		TmTask tsk = this.findById(id);
		
		if(state == 2 || state == 5)
		{
			if(progress == 100)
			{
				endDate = ",tmtask.REAL_END_TIME = to_date('" + format.format(new Date())+ "', 'yyyy/mm/dd hh24:mi:ss')";
			}
			else
			{
				state = 4;
			}
		}
		if(tsk.getTskStatus().equals("No Start") && state == 4)
		{
			startDate = ",tmtask.REAL_START_TIME = to_date('" + format.format(new Date())+ "', 'yyyy/mm/dd hh24:mi:ss')";
		}
		
		String query = "UPDATE TM_TASK tmtask"
					 +" SET tmtask.REAL_PERCENT_PROGRESS = "+progress
					 +" , tmtask.FK_TM_TASK_STATUS = "+state
					 +endDate+startDate
					 +" WHERE tmtask.PK_TM_TASK = "+id;
		
		Connection cn = new SQLConnection().getInstance();
		new UpdateSQLHandler(query, cn).executeQuery();
		cn.close();
		
	}

	@Override
	public List<TmTask> findAllswitch(String startDate, String endDate,
			String status, String respTeam, String owner, String nameTask) throws SQLException {
		// TODO Auto-generated method stub
		
		List<TmTask> list = null;
		String query = GenericSql.queryTasKManger;
		
		query = query + " where";
		
		if(startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty() )
		{
			query = query + " tmtask.ESTIMATED_START_TIME >= to_date('"+startDate+"', 'yyyy/mm/dd hh24:mi:ss') "
							+" and tmtask.ESTIMATED_END_TIME <= to_date('"+endDate+"', 'yyyy/mm/dd hh24:mi:ss') ";
		}
		if(status != null && !status.isEmpty() && !status.equals("Todos"))
		{
			if(query.endsWith("where"))
			{
				query = query + " tmsts.TASK_STATUS_DESCRIPTION = '"+ status+"'";
			}
			else
			{
				query = query + " and tmsts.TASK_STATUS_DESCRIPTION = '"+ status+"'";
			}
			
		}
		if(owner != null && !owner.isEmpty())
		{
			if(query.endsWith("where"))
			{
				query = query + " tmown.TASK_OWNER_USERNAME = '"+ owner+"'";
				
			}
			else
			{
				query = query + " and tmown.TASK_OWNER_USERNAME = '"+ owner+"'";
			}
			
		}
		if(respTeam != null && !respTeam.isEmpty())
		{
			if(query.endsWith("where"))
			{
				
				query = query + " tmteam.TEAM_NAME = '"+ respTeam+"'";
			}
			else
			{
				query = query + " and tmteam.TEAM_NAME = '"+ respTeam+"'";
			}
		}
		if(nameTask != null && !nameTask.isEmpty())
		{
			if(query.endsWith("where"))
			{
				query = query + " UPPER(tmtask.TASK_DESCRIPTION) LIKE UPPER ('%"+nameTask+"%')";
			}
			else
			{
				query = query + " and UPPER(tmtask.TASK_DESCRIPTION) LIKE UPPER ('%"+nameTask+"%') ";
			}
		}
		
		Connection cn = new SQLConnection().getInstance();
		
		System.out.println(query);
		
		list = new TmTaskAdapter().getTaskMangerList(new QuerySQLHandler(query,cn).getResultSet());
		cn.close();
		
		return list;
	}
	
}
