package com.vickyvirus.udaan.admin.dao;

import com.vickyvirus.udaan.admin.entity.Admin;

public interface AdminDao {
	
	public void addAdmin(Admin admin);

	public Admin verifyLogin(String username, String password);
}
