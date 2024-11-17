package com.useraccessmanagementsystem.service;

import java.util.List;

import com.useraccessmanagementsystem.model.Requests;

public interface IRequestsService {
	Integer saveRequest(Requests request);
	List<Requests> findRequestByUserId(Integer id);
	List<Requests> findPendingRequests();
	Integer approveRequest(Integer id);
}
