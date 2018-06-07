package org.product.repository;

import java.util.UUID;

import org.product.jpaModel.SalePK;
import org.product.jpaModel.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSaleRepository extends JpaRepository<Sales, SalePK> {

}
