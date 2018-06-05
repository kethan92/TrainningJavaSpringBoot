package org.product.service;

import java.util.List;

import org.product.jpaModel.Product;
import org.product.repository.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaProductService {
	
	@Autowired
	JpaProductRepository jpaProductRepository;
	
	public List<Product> getAllProduct(){
		return this.jpaProductRepository.findAll();
	}

}
