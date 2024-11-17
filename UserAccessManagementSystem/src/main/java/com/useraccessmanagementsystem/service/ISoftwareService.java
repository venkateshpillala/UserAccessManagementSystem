package com.useraccessmanagementsystem.service;

import java.util.List;

import com.useraccessmanagementsystem.model.Software;

public interface ISoftwareService {
	Integer saveSoftware(Software software);
	Software findSoftwareByName(String name);
	List<Software> getAllSoftwares();
}
