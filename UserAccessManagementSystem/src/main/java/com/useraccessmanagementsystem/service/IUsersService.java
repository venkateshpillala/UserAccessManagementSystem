package com.useraccessmanagementsystem.service;

import com.useraccessmanagementsystem.model.Users;

public interface IUsersService {
	Integer saveUser(Users user);
	Users findUserByUsername(String username);
	Users validate(Users user);
}
