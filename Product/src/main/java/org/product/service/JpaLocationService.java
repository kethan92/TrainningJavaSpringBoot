package org.product.service;

import java.util.List;

import org.product.jpaModel.Location;
import org.product.jpaModel.Product;
import org.product.repository.JpaLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaLocationService {
	
	@Autowired
	JpaLocationRepository jpaLocationRepository;
	
	
	public List<Location> getAllLocation(){
		return this.jpaLocationRepository.findAll();
	}
	
	
	public Location save(Location location) {
//		this.jpaProductRepository.save(product);
		if(location == null) {
			return null;
		}
		else {
			try {			
				return jpaLocationRepository.save(location);
				
			}
			catch (Exception e) {
				System.err.println("Caught IOException: " + e.getMessage());
			}
		}
		return location;
	}

}
