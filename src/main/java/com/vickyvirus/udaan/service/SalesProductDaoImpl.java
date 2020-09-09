package com.vickyvirus.udaan.service;

import java.util.List;
import java.util.stream.Collectors;

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
	public List<Sale> getAllSalesProducts(String numberOfRecords) {
		if(!numberOfRecords.equals("all"))
			return saleRepository.getAllSalesProducts(Integer.parseInt(numberOfRecords));
		else
			return saleRepository.findAll();
	
		
	
	}

	@Override
	public List<Sale> sortByPrice() {
		List<Sale> sales = saleRepository.findAll();
		List<Sale> sortedSales = sales.stream().sorted((s1,s2)->s1.getProductPrice().compareTo(s2.getProductPrice())).collect(Collectors.toList());
		return sortedSales;
	}

	@Override
	public List<Sale> sortByPopularity() {
		
		return saleRepository.findAllByOrderByProductIdDesc();
	}

}
