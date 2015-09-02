package com.tusaludsv.model.adapter;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tusaludsv.model.entity.TmTaskStatus;

public class TmTaskStatusAdapter {
	
	public List<TmTaskStatus> getListStatus(ResultSet rs)
	{
		List<TmTaskStatus> list = new ArrayList<TmTaskStatus>();
		
		try {
			rs.beforeFirst();
			
			while(rs.next())
			{
				list.add(new TmTaskStatus(
						rs.getString("PK_TM_TASK_STATUS"), 
						rs.getString("TASK_STATUS_DESCRIPTION")
							)
						);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}

}
