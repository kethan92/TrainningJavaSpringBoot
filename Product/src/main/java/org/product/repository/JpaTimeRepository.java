package org.product.repository;

import java.util.UUID;

import org.product.jpaModel.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTimeRepository extends JpaRepository<Time, UUID> {

}
