package com.useraccessmanagementsystem.service;

import com.useraccessmanagementsystem.dao.IUsersDao;
import com.useraccessmanagementsystem.dao.UsersDaoImple;
import com.useraccessmanagementsystem.model.Users;

public class UsersServiceImple implements IUsersService {

	private IUsersDao userDao = null;
	
	@Override
	public Integer saveUser(Users user) {
		userDao = new UsersDaoImple();
		return userDao.saveUser(user);
	}

	@Override
	public Users findUserByUsername(String username) {
		userDao = new UsersDaoImple();
		return userDao.findUserByUsername(username);
	}

	@Override
	public Users validate(Users user) {
		userDao = new UsersDaoImple();
		Users db = userDao.findUserByUsername(user.getUsername());
		if(db != null)
			if(user.getUsername().equals(db.getUsername()) && user.getPassword().equals(db.getPassword())) 
				return db;
			
		return null;
	}

}
