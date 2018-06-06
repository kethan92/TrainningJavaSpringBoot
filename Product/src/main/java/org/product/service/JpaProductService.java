package org.product.service;

import java.util.List;
import java.util.UUID;

import org.product.jpaModel.Product;
import org.product.repository.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaProductService  {
	
	@Autowired
	JpaProductRepository jpaProductRepository;
	
	public List<Product> getAllProduct(){
		return (List<Product>) this.jpaProductRepository.findAll();
	}
	
	public Product save(Product product) {
//		this.jpaProductRepository.save(product);
		if(product == null) {
			return null;
		}
		else {
			try {			
				return jpaProductRepository.save(product);
				
			}
			catch (Exception e) {
				System.err.println("Caught IOException: " + e.getMessage());
			}
		}
		return product;
	}

}
