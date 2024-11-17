package com.useraccessmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.useraccessmanagementsystem.model.Software;
import com.useraccessmanagementsystem.utility.JdbcConnection;

public class SoftwareDaoImple implements ISoftwareDao {

	private static final String SAVE = "INSERT INTO software (name,description,access_levels) VALUES(?,?,?)";
	private static final String FIND_BY_NAME = "SELECT * FROM software WHERE name = ?";
	private static final String FIND_ALL = "SELECT * FROM software";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public Integer saveSoftware(Software software) {
		Integer result = 0;
		try {
			con = JdbcConnection.connect();
			if(con != null)
				pstmt = con.prepareStatement(SAVE);
			if(pstmt != null) {
				pstmt.setString(1, software.getName());
				pstmt.setString(2, software.getDescription());
				pstmt.setString(3, software.getAccess_levels());
				
				result = pstmt.executeUpdate();
			}
		}
		catch(Exception e) {
			result = 0;
		}
		return result;
	}

	@Override
	public Software findSoftwareByName(String name) {
		Software software = null;
		try {
			con = JdbcConnection.connect();
			if(con != null)
				pstmt = con.prepareStatement(FIND_BY_NAME);
			if(pstmt != null) {
				pstmt.setString(1, name);
				
				rs = pstmt.executeQuery();
			}
			if(rs.next()) {
				software = new Software();
				
				software.setId(rs.getInt(1));
				software.setName(rs.getString(2));
				software.setDescription(rs.getString(3));
				software.setAccess_levels(rs.getString(4));
						
			}
		}
		catch(Exception e) {
			software = null;
		}
		return software;
	}

	@Override
	public List<Software> getAllSoftwares() {
		List<Software> softwares = null;
		Software software = null;
		try {
			con = JdbcConnection.connect();
			if(con != null)
				pstmt = con.prepareStatement(FIND_ALL);
			if(pstmt != null)
				rs = pstmt.executeQuery();
			if(rs != null) {
				softwares = new ArrayList();
				while(rs.next()) {
					software = new Software();
					
					software.setId(rs.getInt(1));
					software.setName(rs.getString(2));
					software.setDescription(rs.getString(3));
					software.setAccess_levels(rs.getString(4));
					
					softwares.add(software);
				}
			}
		}
		catch(Exception e) {
			softwares = null;
		}
		return softwares;
	}

}
