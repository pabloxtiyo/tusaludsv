/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tusaludsv.model.dao.dbaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.tusaludsv.exceptions.DatabaseException;

/**
 *
 * @author pportillo
 */
public class QuerySQLHandler 
{
    static Logger log = Logger.getLogger(QuerySQLHandler.class);
    private final Statement st;
    private final ResultSet rs;
    
    public QuerySQLHandler(String query, Connection cn) throws DatabaseException
    {
        //log.debug("creating the statement object");
        try 
        {
			 st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			 rs = st.executeQuery(query);
		} 
        catch (SQLException e) 
        {
			// TODO Auto-generated catch block
			log.error("Error al ejecutar query "+e.getMessage());
			throw new DatabaseException("Error al realizar consulta sql "+e.getMessage());
		}
        //log.debug("execute the query");
       
    }
    
    public ResultSet getResultSet()
    {
        log.debug("return the rs");
        return this.rs;
        
    }
}

