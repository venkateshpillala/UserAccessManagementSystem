package com.useraccessmanagementsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.useraccessmanagementsystem.model.Requests;
import com.useraccessmanagementsystem.service.IRequestsService;
import com.useraccessmanagementsystem.service.RequestsServiceImple;

@WebServlet("/approvalServlet")
public class ApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IRequestsService requestService = null;
	private Requests req = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		requestService = new RequestsServiceImple();
		
		List<Requests> requests = requestService.findPendingRequests();
		
		request.setAttribute("pending", requests);
		
		request.getRequestDispatcher("./pendingRequests.jsp").forward(request, response);

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		requestService = new RequestsServiceImple();
		requestService.approveRequest(Integer.parseInt(request.getParameter("id")));
		
		request.getRequestDispatcher("/.pendingRequests.jsp").forward(request, response);
	}

}
