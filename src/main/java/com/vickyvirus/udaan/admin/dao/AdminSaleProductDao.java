package com.vickyvirus.udaan.admin.dao;

import java.util.List;

import com.vickyvirus.udaan.admin.entity.Sale;

public interface AdminSaleProductDao {

	public void saveSaleProduct(Sale sale);
	
	public List<Sale> getAllSalesData();
	
	public Sale getSelectedSale(Integer productId);
	
	public List<Sale> getAllSalesDataExceptSelected(Integer productId);

	public void updateSaleProduct(Sale sale);

	public void deleteSaleData(Integer productId);
}
