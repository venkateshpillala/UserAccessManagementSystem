package com.useraccessmanagementsystem.dao;

import java.util.List;

import com.useraccessmanagementsystem.model.Software;

public interface ISoftwareDao {
	Integer saveSoftware(Software software);
	Software findSoftwareByName(String name);
	List<Software> getAllSoftwares();
}
