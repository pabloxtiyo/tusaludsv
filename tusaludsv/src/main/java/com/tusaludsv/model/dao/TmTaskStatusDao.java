package com.tusaludsv.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tusaludsv.model.adapter.TmTaskStatusAdapter;
import com.tusaludsv.model.dao.dbaccess.QuerySQLHandler;
import com.tusaludsv.model.dao.dbaccess.SQLConnection;
import com.tusaludsv.model.entity.TmTaskStatus;

@Component
public class TmTaskStatusDao implements GenericDao<TmTaskStatus> {

	@Override
	public TmTaskStatus insert(TmTaskStatus entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TmTaskStatus update(TmTaskStatus entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(TmTaskStatus entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TmTaskStatus> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection cn = new SQLConnection().getInstance();
		
		List<TmTaskStatus> list = new TmTaskStatusAdapter().getListStatus(new QuerySQLHandler(GenericSql.queryStatus,cn).getResultSet());
		
		cn.close();
		return list;
	}

	@Override
	public List<TmTaskStatus> findAllswitch(String startDate, String endDate,
			String status, String respTeam, String equip, String nameTask) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TmTaskStatus findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
