package org.product.service;

import java.util.List;

import org.product.jpaModel.Location;
import org.product.jpaModel.Time;
import org.product.repository.JpaTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaTimeService {

	@Autowired
	private JpaTimeRepository jpaTimeRepository;
	
	public List<Time> getAllTime(){
		return this.jpaTimeRepository.findAll();
	}
	
	
	public Time save(Time time) {
//		this.jpaProductRepository.save(product);
		if(time == null) {
			return null;
		}
		else {
			try {			
				return jpaTimeRepository.save(time);
				
			}
			catch (Exception e) {
				System.err.println("Caught IOException: " + e.getMessage());
			}
		}
		return time;
	}
}
