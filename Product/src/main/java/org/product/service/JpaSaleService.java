package org.product.service;

import java.util.List;
import java.util.UUID;

import org.product.jpaModel.Sales;
import org.product.jpaModel.SalesPK;
import org.product.repository.JpaSaleRepository;
import org.product.repository.LocationRepository;
import org.product.repository.ProductRepository;
import org.product.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaSaleService {
	
	@Autowired
	JpaSaleRepository jpaSaleRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	TimeRepository timeRepository;
	
	public List<Sales> getAllSales(){
		return this.jpaSaleRepository.findAll();
	}

	public Sales save(Sales salesJPA) {
		// TODO Auto-generated method stub
		if(salesJPA == null) {
			return null;
		}
		else {
			try {			
				return jpaSaleRepository.save(salesJPA);
				
			}
			catch (Exception e) {
				System.err.println("Caught IOException: " + e.getMessage());
			}
		}
		return salesJPA;
		
	}
	
	public void addSaleTaltol(List<org.product.model.Sales> listSales) {
		SalesPK salesId=null;
		UUID uuid=null;
		for(org.product.model.Sales sales: listSales) {
			uuid=UUID.randomUUID();
			salesId=new SalesPK(sales.getProduct_id(),sales.getTime_id(),sales.getLocation_id());
			
				Sales sa=new Sales();
				sa.setSaleId(uuid);
				sa.setSalesPK(salesId);
			
				sa.setDollars(sales.getDollars());
				
				//jpaSaleRepository.save(sa);
				jpaSaleRepository.save(sa);
			
			
		}
		return;
		
	}

}
