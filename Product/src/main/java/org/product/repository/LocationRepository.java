package org.product.repository;

import java.util.UUID;

import org.product.model.Location;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CassandraRepository<Location, UUID> {

}
