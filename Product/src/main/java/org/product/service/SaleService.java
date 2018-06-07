package org.product.service;

import java.util.List;

import org.product.model.Sales;

import org.product.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService extends BaseService {
	
	@Autowired
	private SalesRepository salesRepository;
	
	public List<Sales> getAllSales(){
		return this.salesRepository.findAll();
	}

}
