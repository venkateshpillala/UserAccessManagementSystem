package com.useraccessmanagementsystem.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {

	
	public static Connection connect() throws SQLException{
		Connection con = null;
		FileInputStream fis = null;
		Properties p = null;
		try {
			fis = new FileInputStream("D:\\Java\\MultiThreading\\UserAccessManagementSystem\\src\\main\\java\\com\\useraccessmanagementsystem\\utility\\application.properties");
			p = new Properties();
			p.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		con = DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
		
		return con;
	}
}
