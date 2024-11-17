package com.useraccessmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.useraccessmanagementsystem.model.Users;
import com.useraccessmanagementsystem.utility.JdbcConnection;

public class UsersDaoImple implements IUsersDao {

	private static final String SAVE = "INSERT INTO users (username,password,role) VALUES(?,?,?)";
	private static final String FIND_BY_ID = "SELECT * FROM users WHERE username = ?";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public Integer saveUser(Users user) {
		Integer result = 0;
		try {
			con = JdbcConnection.connect();
			if(con != null)
				pstmt = con.prepareStatement(SAVE);
			if(pstmt != null) {
				pstmt.setString(1,user.getUsername());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getRole());
				
				result = pstmt.executeUpdate();
				System.out.println(result);
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public Users findUserByUsername(String username) {
		
		Users user = null;
		try {
			con = JdbcConnection.connect();
			if(con != null)
				pstmt = con.prepareStatement(FIND_BY_ID);
			if(pstmt != null) {
				pstmt.setString(1, username);
				rs = pstmt.executeQuery();
			}
			if(rs.next()) {
				user = new Users();
				
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
				
				
			}
		}
		catch(Exception e) {
			user = null;
		}
		return user;
	}

}
