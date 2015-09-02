/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tusaludsv.model.dao.dbaccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.tusaludsv.exceptions.DatabaseException;

/**
 *
 * @author pportillo
 */
public class UpdateSQLHandler 
{
 
    static Logger log = Logger.getLogger(UpdateSQLHandler.class);
    private final Statement st;
    private final String query;
    
    public UpdateSQLHandler(String query, Connection cn) throws DatabaseException 
    {
    	
        try 
        {
        	this.query = query;
			this.st = cn.createStatement();
		} 
        	catch (SQLException e) 
        {
			// TODO Auto-generated catch block
        	log.error(e);	
			throw new DatabaseException("Error al crear el objeto statement "+e.getMessage());
		}
        
    }

    public void executeQuery() throws DatabaseException
    {
        
            try 
            {
            	log.debug("Realizando insert en la base de datos");
				st.executeUpdate(query);
				
			} 
            catch (SQLException e) 
            {
				// TODO Auto-generated catch block
            	log.error(e);	
    			throw new DatabaseException("Error al ejecutar el insert "+e.getMessage());
			}
    }
    
}
