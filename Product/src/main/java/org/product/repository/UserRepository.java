package org.product.repository;

import java.util.UUID;
import org.product.jpaModel.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
	
	@Query("SELECT p FROM app_user p WHERE p.user_name = :username")
	AppUser findUserAccount(@Param("username") String username);

}
