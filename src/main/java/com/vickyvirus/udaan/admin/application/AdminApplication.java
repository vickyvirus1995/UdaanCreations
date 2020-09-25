package com.vickyvirus.udaan.admin.application;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vickyvirus.udaan.admin.dao.AdminDao;
import com.vickyvirus.udaan.admin.entity.Admin;

@Component	
public class AdminApplication {

	@Autowired
	AdminDao adminDao;
	
	public void addAdmin(String username, String password) {
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		adminDao.addAdmin(admin);
		
	}

	public boolean verifyLogin(String username, String password) {
		Admin admin = adminDao.verifyLogin(username,password);
		if(Objects.isNull(admin))
			return false;
		return true;
	}

}
