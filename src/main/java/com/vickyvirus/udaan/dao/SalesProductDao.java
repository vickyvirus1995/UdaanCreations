package com.vickyvirus.udaan.dao;

import java.util.List;

import com.vickyvirus.udaan.admin.entity.Sale;

public interface SalesProductDao {

	public List<Sale> getLatestSalesProducts();

	public List<Sale> getAllSalesProducts();
}
