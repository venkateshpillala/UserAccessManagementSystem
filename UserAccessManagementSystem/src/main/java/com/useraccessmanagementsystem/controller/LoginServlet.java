package com.useraccessmanagementsystem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.useraccessmanagementsystem.model.Users;
import com.useraccessmanagementsystem.service.IUsersService;
import com.useraccessmanagementsystem.service.UsersServiceImple;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession session = null;
	
	private Users user = null;
	private IUsersService userService = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet.doGet()");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("LoginServlet.doPost()");
		user = new Users();
		userService = new UsersServiceImple();
		
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		Users afterValidation = userService.validate(user);
		
		if(afterValidation != null) {
			session = request.getSession();
			session.setAttribute("user", afterValidation);
			
			if(afterValidation.getRole().equalsIgnoreCase("EMPLOYEE"))
				request.getRequestDispatcher("./employee/requestAccess").forward(request, response);
			
			if(afterValidation.getRole().equalsIgnoreCase("MANAGER"))
				request.getRequestDispatcher("./approvalServlet").forward(request, response);
				
			if(afterValidation.getRole().equalsIgnoreCase("ADMIN"))
				request.getRequestDispatcher("./createSoftware.jsp").forward(request, response);
		}
		else {
			request.setAttribute("user", afterValidation);
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		}
	}
}
