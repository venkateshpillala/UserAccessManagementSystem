package com.useraccessmanagementsystem.service;

import java.util.List;

import com.useraccessmanagementsystem.dao.IRequestsDao;
import com.useraccessmanagementsystem.dao.RequestsDaoImple;
import com.useraccessmanagementsystem.model.Requests;

public class RequestsServiceImple implements IRequestsService {

	private IRequestsDao requestDao = null;
	
	
	@Override
	public Integer saveRequest(Requests request) {
		requestDao = new RequestsDaoImple();
		return requestDao.saveRequest(request);
	}

	@Override
	public List<Requests> findRequestByUserId(Integer user_id) {
		requestDao = new RequestsDaoImple();
		return requestDao.findRequestByUserId(user_id);
	}

	@Override
	public List<Requests> findPendingRequests() {
		requestDao = new RequestsDaoImple();
		return requestDao.findPendingRequests();
	}

	@Override
	public Integer approveRequest(Integer id) {
		requestDao = new RequestsDaoImple();
		return requestDao.approveRequest(id);
	}

}
