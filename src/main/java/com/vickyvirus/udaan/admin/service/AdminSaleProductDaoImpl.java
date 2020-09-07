package com.vickyvirus.udaan.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vickyvirus.udaan.admin.dao.AdminSaleProductDao;
import com.vickyvirus.udaan.admin.entity.Sale;
import com.vickyvirus.udaan.repository.SaleRepository;

@Component
public class AdminSaleProductDaoImpl implements AdminSaleProductDao{

	@Autowired
	private SaleRepository saleRepository;
	
	@Override
	public void saveSaleProduct(Sale sale) {
		saleRepository.save(sale);
		
	}

	@Override
	public List<Sale> getAllSalesData() {
		return saleRepository.findAll();
	}

	@Override
	public Sale getSelectedSale(Integer productId) {
		
		return saleRepository.findById(productId).orElse(new Sale());
	}

	@Override
	public List<Sale> getAllSalesDataExceptSelected(Integer productId) {
		
		return saleRepository.getAllSalesDataExceptSelected(productId);
	}

	@Override
	public void updateSaleProduct(Sale sale) {
		saleRepository.save(sale);
		
	}

	@Override
	public void deleteSaleData(Integer productId) {
		saleRepository.deleteById(productId);
		
	}

}
