package org.product.repository;

import java.util.List;

import org.product.jpaModel.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RoleRepository extends JpaRepository<AppRole, Long> {
	
	List<String> getRoleNames(Long userId);

}
