package org.product.repository;

import java.util.UUID;

import org.product.jpaModel.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLocationRepository extends JpaRepository<Location, UUID> {

}
