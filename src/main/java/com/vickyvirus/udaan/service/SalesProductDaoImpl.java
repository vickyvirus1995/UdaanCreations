package com.vickyvirus.udaan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vickyvirus.udaan.admin.entity.Sale;
import com.vickyvirus.udaan.dao.SalesProductDao;
import com.vickyvirus.udaan.repository.SaleRepository;

@Service
public class SalesProductDaoImpl implements SalesProductDao {

	@Autowired
	private SaleRepository saleRepository;
	
	@Override
	public List<Sale> getLatestSalesProducts() {
		
		return saleRepository.getLatestSalesProducts();
	}

	@Override
	public List<Sale> getAllSalesProducts() {
		
		return saleRepository.findAll();
	}

}
