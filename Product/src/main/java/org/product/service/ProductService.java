
package org.product.service;

import java.util.List;
import java.util.UUID;


import org.product.model.Product;
import org.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService extends BaseService {
	@Autowired 
	private ProductRepository productRepository;
	
//	public Product findById(string id) {
//		if(id==null) {
//			return null;
//		}
//		return productRepository.findOne(id);
//	}
	public List<Product> getAllProduct(){
		logger.info("++++++++++++++++++++THAN+++++++++++++++++++");
		return productRepository.findAll();
	}
	
	public List<Product> getProductByItem(int item){
		return productRepository.findByItem(item);
	}
	
	public Product addProduct(Product product) {
		if(product == null) {
			return null;
		}
		else {
			try {
				UUID uuid=UUID.randomUUID();
				product.setProduct_id(uuid);
				return productRepository.save(product);
				
			}
			catch (Exception e) {
				System.err.println("Caught IOException: " + e.getMessage());
			}
		}
		return product;
	}
	
	
	

}
