package com.useraccessmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.useraccessmanagementsystem.model.Requests;
import com.useraccessmanagementsystem.utility.JdbcConnection;

public class RequestsDaoImple implements IRequestsDao {

	private static final String SAVE = "INSERT INTO requests (user_id,software_id,access_type,reason,status) VALUES(?,?,?,?,?)";
	private static final String FIND_BY_USER_ID = "SELECT * FROM requests WHERE user_id = ?";
	private static final String FIND_PENDING_REQUESTS = "SELECT * FROM requests WHERE status = 'pending'";
	private static final String UPDATE_STATUS = "UPDATE requests SET status = 'APPROVED' WHERE id = ?";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public Integer saveRequest(Requests request) {
		Integer result = 0;
		try {
			con = JdbcConnection.connect();
			if(con != null)
				pstmt = con.prepareStatement(SAVE);
			if(pstmt != null) {
				pstmt.setInt(1, request.getUser_id());
				pstmt.setInt(2, request.getSoftware_id());
				pstmt.setString(3,request.getAccess_type());
				pstmt.setString(4, request.getReason());
				pstmt.setString(5, request.getStatus());
				
				result = pstmt.executeUpdate();
			}
		}
		catch(Exception e) {
			result = 0;
		}
		return result ;
	}

	@Override
	public List<Requests> findRequestByUserId(Integer user_id) {
		Requests request = null;
		List<Requests> requests = null;
		try {
			con = JdbcConnection.connect();
			if(con != null)
				pstmt = con.prepareStatement(FIND_BY_USER_ID);
			if(pstmt != null) {
				pstmt.setInt(1, user_id);
				
				rs = pstmt.executeQuery();
			}
			if(rs != null) {
				requests = new ArrayList();
				while(rs.next()) {
					request = new Requests();
				
					request.setId(rs.getInt(1));
					request.setUser_id(rs.getInt(2));
					request.setSoftware_id(rs.getInt(3));
					request.setAccess_type(rs.getString(4));
					request.setReason(rs.getString(5));
					request.setStatus(rs.getString(6));
					
					requests.add(request);
				}
			}
		}
		catch(Exception e) {
			request = null;
		}
		return requests;
	}

	@Override
	public List<Requests> findPendingRequests() {
		List<Requests> pendingRequests = null;
		Requests request = null;
		try {
			con = JdbcConnection.connect();
			if(con != null)
				pstmt = con.prepareStatement(FIND_PENDING_REQUESTS);
			if(pstmt != null)
				rs = pstmt.executeQuery();
			if(rs != null) {
				pendingRequests = new ArrayList();
				while(rs.next()) {
					request = new Requests();
					
					request.setId(rs.getInt(1));
					request.setUser_id(rs.getInt(2));
					request.setSoftware_id(rs.getInt(3));
					request.setAccess_type(rs.getString(4));
					request.setReason(rs.getString(5));
					request.setStatus(rs.getString(6));
					
					pendingRequests.add(request);
				}
			}
		}
		catch(Exception e) {
			pendingRequests = null;
		}
		return pendingRequests;
	}

	@Override
	public Integer approveRequest(Integer id) {
		Integer result = 0;
		try {
			con = JdbcConnection.connect();
			if(con != null)
				pstmt = con.prepareStatement(UPDATE_STATUS);
			if(pstmt != null) {
				pstmt.setInt(1, id);
				result = pstmt.executeUpdate();
			}
		}
		catch(Exception e) {
			result = 0;
		}
		return result;
	}

}
