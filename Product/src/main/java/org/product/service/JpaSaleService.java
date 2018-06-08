package org.product.service;

import org.product.jpaModel.Sales;
import org.product.repository.JpaSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaSaleService {
	
	@Autowired
	JpaSaleRepository jpaSaleRepository;

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

}
