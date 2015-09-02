/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tusaludsv.model.dao.dbaccess;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tusaludsv.exceptions.DatabaseException;

/**
 *
 * @author pportillo
 */

public class SQLConnection 
{
    private static Connection cn;
    private static Properties prop;
    private String user,pass,server,sid,port,jdbcURL;
    private static final Logger log = LoggerFactory.getLogger(SQLConnection.class);

    public SQLConnection() {
        
    }
    
    public  Connection getInstance()
    {
        
      try
        {
    	  String propFileName = "database.properties";
    	  
    	  InputStream inputStream = SQLConnection.class.getClassLoader().getResourceAsStream(propFileName);
    	  
        prop = new Properties();
        prop.load(inputStream);
        user = prop.getProperty("user");
        pass = prop.getProperty("password");
        server = prop.getProperty("server");
        port  = prop.getProperty("port");
        sid = prop.getProperty("sid");
        jdbcURL = "jdbc:oracle:thin:@" + server + ":" + port
				+ ":" + sid;
        
        log.debug("username "+user);
        log.debug("password "+pass);
        log.debug("server "+server);
        log.debug("bd "+sid);
        log.debug("url "+jdbcURL);
            
        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        
        cn = DriverManager.getConnection(jdbcURL,user,pass);
          
            return cn;  
        } 
      catch (ClassNotFoundException | SQLException | IOException | InstantiationException | IllegalAccessException ex) 
        {
    	   log.error("Error de conexi�n con la base de datos");
    	   ex.printStackTrace();
    	   throw new DatabaseException("Error de conexion con la base de datos "+ ex.getMessage());
           
        } 
      
       
    }
    
    
}

