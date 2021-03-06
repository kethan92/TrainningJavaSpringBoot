package org.product.repository;

import java.util.UUID;

import org.product.model.Sales;
import org.product.model.Time;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface SalesRepository extends CassandraRepository<Sales, UUID> {

}
