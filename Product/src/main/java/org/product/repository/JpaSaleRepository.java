package org.product.repository;




import org.product.jpaModel.Sales;
import org.product.jpaModel.SalesPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSaleRepository extends JpaRepository<Sales, SalesPK> {
	
	

}
