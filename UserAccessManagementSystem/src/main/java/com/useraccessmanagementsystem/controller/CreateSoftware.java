package com.useraccessmanagementsystem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.useraccessmanagementsystem.model.Software;
import com.useraccessmanagementsystem.service.ISoftwareService;
import com.useraccessmanagementsystem.service.SoftwareServiceImple;


@WebServlet("/createSoftware")
public class CreateSoftware extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Software software = null;
	ISoftwareService softwareService = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		software = new Software();
		softwareService = new SoftwareServiceImple();
		
		software.setName(request.getParameter("name"));
		software.setDescription(request.getParameter("description"));;
		software.setAccess_levels(request.getParameter("access_levels"));
		
		Integer result = softwareService.saveSoftware(software);
		request.setAttribute("software", result);
		
		if(result != 0) {
			request.getRequestDispatcher("./createSoftware.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		}
	}

}
