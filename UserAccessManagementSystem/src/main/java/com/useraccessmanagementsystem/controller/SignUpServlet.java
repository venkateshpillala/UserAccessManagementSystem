package com.useraccessmanagementsystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.useraccessmanagementsystem.model.Users;
import com.useraccessmanagementsystem.service.IUsersService;
import com.useraccessmanagementsystem.service.UsersServiceImple;

@WebServlet("/signupServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Users user = null;
	private IUsersService userService = null;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("SignUpServlet.doPost()");
		user = new Users();
		userService = new UsersServiceImple();
		
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role"));
		
		Integer result = userService.saveUser(user);
		
		if(result != 0) {
			System.out.println("Success");
			request.getRequestDispatcher("./login.jsp").forward(request, response);
		}
		else {
			System.out.println("Failed");
			request.setAttribute("result", result);
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		}
		
	}

}
