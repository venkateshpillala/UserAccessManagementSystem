package com.useraccessmanagementsystem.service;

import java.util.List;

import com.useraccessmanagementsystem.dao.ISoftwareDao;
import com.useraccessmanagementsystem.dao.SoftwareDaoImple;
import com.useraccessmanagementsystem.model.Software;

public class SoftwareServiceImple implements ISoftwareService {

	private ISoftwareDao softwareDao = null;
	
	@Override
	public Integer saveSoftware(Software software) {
		softwareDao = new SoftwareDaoImple();
		return softwareDao.saveSoftware(software);
	}

	@Override
	public Software findSoftwareByName(String name) {
		softwareDao = new SoftwareDaoImple();
		return softwareDao.findSoftwareByName(name);
	}

	@Override
	public List<Software> getAllSoftwares() {
		softwareDao = new SoftwareDaoImple();
		return softwareDao.getAllSoftwares();
	}

}
