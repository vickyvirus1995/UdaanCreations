package com.vickyvirus.udaan.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vickyvirus.udaan.admin.dao.AdminDao;
import com.vickyvirus.udaan.admin.entity.Admin;
import com.vickyvirus.udaan.repository.AdminRepository;

@Service
public class AdminDaoImpl implements AdminDao{

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public void addAdmin(Admin admin) {
		adminRepository.save(admin);
		
	}

	@Override
	public Admin verifyLogin(String username, String password) {
		Admin admin = adminRepository.verifyLogin(username, password);
		return admin;
		
	}

}
