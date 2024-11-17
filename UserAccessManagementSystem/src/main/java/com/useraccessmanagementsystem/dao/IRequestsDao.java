package com.useraccessmanagementsystem.dao;

import java.util.List;

import com.useraccessmanagementsystem.model.Requests;

public interface IRequestsDao {
	Integer saveRequest(Requests request);
	List<Requests> findRequestByUserId(Integer id);
	List<Requests> findPendingRequests();
	Integer approveRequest(Integer id);
}
