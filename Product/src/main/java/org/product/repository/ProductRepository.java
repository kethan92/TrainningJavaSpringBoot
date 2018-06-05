package org.product.repository;

import java.util.List;
import java.util.UUID;

import org.product.model.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CassandraRepository<Product, UUID>{
	
	@Query("SELECT * FROM product WHERE item = ?0 ALLOW FILTERING")
	public List<Product> findByFirstname(int item);
	
	
//	public ResponseEntity<?> addProduct(@RequestBody Product product) {
//	
//	}
	

}
