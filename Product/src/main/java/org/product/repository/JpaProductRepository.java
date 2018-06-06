package org.product.repository;

import org.product.jpaModel.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaProductRepository extends JpaRepository<Product, UUID> {

	
}
