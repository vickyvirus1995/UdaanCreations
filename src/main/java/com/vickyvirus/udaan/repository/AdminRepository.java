package com.vickyvirus.udaan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vickyvirus.udaan.admin.entity.Admin;
import com.vickyvirus.udaan.entity.Product;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Query(nativeQuery = true,value = "Select * from admin where username = ?1 and password = ?2 ")
	Admin verifyLogin(String username,String password);
}
