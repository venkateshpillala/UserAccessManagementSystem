package com.useraccessmanagementsystem.dao;

import com.useraccessmanagementsystem.model.Users;

public interface IUsersDao {
	Integer saveUser(Users user);
	Users findUserByUsername(String username);
}
