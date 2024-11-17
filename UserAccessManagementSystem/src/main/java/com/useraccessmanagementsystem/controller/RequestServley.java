package com.useraccessmanagementsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.useraccessmanagementsystem.model.Requests;
import com.useraccessmanagementsystem.model.Software;
import com.useraccessmanagementsystem.model.Users;
import com.useraccessmanagementsystem.service.IRequestsService;
import com.useraccessmanagementsystem.service.ISoftwareService;
import com.useraccessmanagementsystem.service.RequestsServiceImple;
import com.useraccessmanagementsystem.service.SoftwareServiceImple;

@WebServlet("/employee/*")
public class RequestServley extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ISoftwareService softwareService = null;
	private IRequestsService requestService = null;
	private Users user = null;
	private Requests req = null;
	private Software software;
	
	
	
	HttpSession session = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request,response);
	
	}
	
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer result = 0;
		
		if(request.getRequestURI().endsWith("/requestAccess")) {
			softwareService = new SoftwareServiceImple();
			List<Software> softwares = softwareService.getAllSoftwares();
			request.setAttribute("softwares", softwares);
			request.getRequestDispatcher("./requestAccess.jsp").forward(request, response);
		}
		
		
		if(request.getRequestURI().endsWith("/getSoftware")) {
			
			software = softwareService.findSoftwareByName(request.getParameter("name"));
			if(software != null) {
				session = request.getSession();
				user = (Users) session.getAttribute("user");
				
				req = new Requests();
				req.setUser_id(user.getId());
				req.setSoftware_id(software.getId());
				req.setAccess_type(request.getParameter("access_type"));
				req.setReason(request.getParameter("reason"));
				req.setStatus("pending");
				
				requestService = new RequestsServiceImple();
				
				result = requestService.saveRequest(req);
				
				request.setAttribute("request", result);
				if(result != 0) {
					request.getRequestDispatcher("./requestAccess.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("./error.jsp").forward(request, response);
				}
			}
		}
		
		if(request.getRequestURI().endsWith("/status")) {
			session = request.getSession();
			user = (Users) session.getAttribute("user");
			requestService = new RequestsServiceImple();
			
			List<Requests> requests = requestService.findRequestByUserId(user.getId());
			request.setAttribute("requests", requests);
			
			if(result != 0) {
				request.getRequestDispatcher("./requestAccess.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("./error.jsp").forward(request, response);
			}
		}
		
	}

}
