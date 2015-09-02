package com.tusaludsv.model.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Autor Pablo.Portillo
 * @FechaCreacion 06/07/2015.10:51:44
 * @Empresa Grupo.GD
 */
public interface GenericDao <T> 
{
	public T insert (T entity);
	public T update (T entity);
	public boolean delete (T entity);
	public List<T> findAll() throws SQLException;
	public List<T> findAllswitch(String startDate, String endDate, String status, 
			String respTeam, String equip,String nameTask ) throws SQLException;
	public T findById(int id);
	
}
